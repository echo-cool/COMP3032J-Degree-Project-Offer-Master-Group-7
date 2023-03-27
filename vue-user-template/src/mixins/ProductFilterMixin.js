import ProductMixin from '@/mixins/ProductMixin'

export default {
    mixins: [ProductMixin],
    data() {
        return {
            filteredProducts: '',
            priceRange: ''
        }
    },
    methods: {
        changeLikes(like) {
            this.filteredProducts = this.products.sort((a, b) => {
                if (like.value === 'most-liked') {
                    return a.reacted < b.reacted ? 1 : -1;
                }
                return a.reacted > b.reacted ? 1 : -1;
            });
        },
        changeCategory(category) {
            if (category.value === 'all') {
                this.filteredProducts = this.products
            } else {
                this.filteredProducts = this.products.filter((product) => product.categories.includes(category.value));
            }
        },
        changeCollection(collection) {
            if (collection.value === 'all') {
                this.filteredProducts = this.products
            } else {
                this.filteredProducts = this.products.filter((product) => product.collection.name === collection.value);
            }
        },
        changeSaleType(type) {
            if (type.value === 'all') {
                this.filteredProducts = this.products
            } else {
                this.filteredProducts = this.products.filter((product) => product.saleType === type.value);
            }
        },
        onChangeRange(value) {
            this.priceRange = value;
        },
        filterPrice() {
            if (this.priceRange.length) {
                this.filteredProducts = this.products.filter(product => {
                    const startRange = this.priceRange[0],
                        endRange = this.priceRange[1]
                    return product.price.amount >= startRange && product.price.amount <= endRange
                });
            }
        }
    },
    mounted() {
        this.filteredProducts = this.products;
    }
}