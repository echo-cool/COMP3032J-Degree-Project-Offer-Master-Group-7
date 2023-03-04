import _ from 'lodash';
import ProductMixin from '@/mixins/ProductMixin'
import AppFunctions from "@/helpers/AppFunctions";

export default {
    mixins: [ProductMixin],
    data() {
        return {
            filteredProducts: '',
            productCategories: '',
            productLevels: '',
            productLanguages: '',
            priceRange: '',
            checkedSortBy: '',
            checkedByPrice: '',
            checkedCategories: [],
            checkedLevels: [],
            checkedLanguages: [],
            checkedRatings: [],
            filteredRows: '',
            pageStart: '',
            countOfPage: ''
        }
    },
    methods: {
        scrollIntoTop() {
            document.getElementById('explore-id')
                .scrollIntoView({behavior: 'smooth'});
        },
        getProductCategories() {
            const cats = AppFunctions.flatDeep(this.products.map((prod) => prod.categories));
            const categories = cats.reduce((obj, b) => {
                const newObj = {...obj};
                newObj[b] = obj[b] + 1 || 1;
                return newObj;
            }, {});
            this.productCategories = categories;
        },
        getProductLevels() {
            const levels = [...new Set(this.products.map((prod) => prod.level))];
            this.productLevels = levels
        },
        getProductLanguages() {
            const languages = [...new Set(this.products.map((prod) => prod.language))];
            this.productLanguages = languages
        },
        sortByFilter() {
            const result = this.filteredProducts.sort((a, b) => {
                switch (this.checkedSortBy) {
                    case 'most-liked':
                        return a.reacted < b.reacted ? 1 : -1;
                    case 'least-liked':
                        return a.reacted > b.reacted ? 1 : -1;
                    case 'oldest':
                        return new Date(a.publishedAt).getTime() >
                        new Date(b.publishedAt).getTime()
                            ? 1
                            : -1;
                    case 'low-to-high':
                        return a.price.amount > b.price.amount ? 1 : -1;
                    case 'high-to-low':
                        return a.price.amount > b.price.amount ? -1 : 1;
                    default:
                        return new Date(b.publishedAt).getTime() >
                        new Date(a.publishedAt).getTime()
                            ? 1
                            : -1;
                }
            });

            this.filteredProducts = result;
            this.filteredRows = this.filteredProducts;
            this.pageStart = 0;
            this.scrollIntoTop();
        },
        filterCategory() {
            let result = this.products.filter(product => {
                if (this.checkedCategories.length) {
                    return this.checkedCategories.some(category => {
                        if (product.categories.includes(category)) {
                            return product;
                        }
                    });
                } else {
                    return product
                }
            });
            this.filteredProducts = result;
            this.filteredRows = this.filteredProducts;
            this.pageStart = 0;
            this.scrollIntoTop();
        },
        filterLevel() {
            let result = this.products.filter(product => {
                if (this.checkedLevels.length) {
                    return this.checkedLevels.some(level => {
                        if (product.level === level) {
                            return product;
                        }
                    });
                } else {
                    return product
                }
            });
            this.filteredProducts = result;
            this.filteredRows = this.filteredProducts;
            this.pageStart = 0;
            this.scrollIntoTop();
        },
        filterLanguages() {
            let result = this.products.filter(product => {
                if (this.checkedLanguages.length) {
                    return this.checkedLanguages.some(language => {
                        if (product.language === language) {
                            return product;
                        }
                    });
                } else {
                    return product
                }
            });
            this.filteredProducts = result;
            this.filteredRows = this.filteredProducts;
            this.pageStart = 0;
            this.scrollIntoTop();
        },
        filterRatings() {
            let result = this.products.filter(product => {
                if (this.checkedRatings.length) {
                    return this.checkedRatings.some(rating => {
                        if (product.rating == rating) {
                            return product;
                        }
                    });
                } else {
                    return product
                }
            });
            this.filteredProducts = result;
            this.filteredRows = this.filteredProducts;
            this.pageStart = 0;
            this.scrollIntoTop();
        },
        priceFilter() {
            const sortedProducts = this.filteredProducts.sort((a, b) => {
                switch (this.checkedByPrice) {
                    case 'low-to-high':
                        return a.price.amount > b.price.amount ? 1 : -1;
                    case 'high-to-low':
                        return a.price.amount > b.price.amount ? -1 : 1;
                    default:
                        return new Date(b.publishedAt).getTime() >
                        new Date(a.publishedAt).getTime()
                            ? 1
                            : -1;
                }
            });

            this.filteredProducts = sortedProducts;
            this.filteredRows = this.filteredProducts;
            this.pageStart = 0;
            this.scrollIntoTop();
        },
        onChangeRange(value) {
            this.priceRange = value;
            this.scrollIntoTop();
        },
        filterPrice() {
            if (this.priceRange.length) {
                this.filteredProducts = this.products.filter(product => {
                    const startRange = this.priceRange[0],
                        endRange = this.priceRange[1]
                    return product.price.amount >= startRange && product.price.amount <= endRange
                });
                this.filteredRows = this.filteredProducts;
                this.pageStart = 0;
            }
        },
        paginatedData(filteredRows, pageStart, countOfPage) {
            this.filteredRows = filteredRows;
            this.pageStart = pageStart;
            this.countOfPage = countOfPage;
        }
    },
    mounted() {
        this.filteredProducts = this.products;
        this.filteredRows = this.filteredProducts;
        this.getProductCategories();
        this.getProductLevels();
        this.getProductLanguages();
    }
}
