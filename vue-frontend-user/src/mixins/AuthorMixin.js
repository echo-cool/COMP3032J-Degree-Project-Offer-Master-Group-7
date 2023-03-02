import ProductMixin from '@/mixins/ProductMixin'

export default {
    mixins: [ProductMixin],
    data() {
        return {
            authorProducts: {
                onSale: '',
                owned: '',
                created: '',
                liked: ''
            },
            authors: [
                {
                    id: 1,
                    isVerified: true,
                    image: require(`@/assets/images/client/client-1.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '1 day',
                    status: 'varified',
                    products: ''
                },
                {
                    id: 2,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-2.png`),
                    name: 'Ms. Parkline',
                    sellingAmount: '$2300,000',
                    topSince: '7 days',
                    status: 'top rated',
                    products: ''
                },
                {
                    id: 3,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-3.png`),
                    name: 'Methods',
                    sellingAmount: '$2100,000',
                    topSince: '30 days',
                    status: 'top rated',
                    products: ''
                },
                {
                    id: 4,
                    isVerified: true,
                    image: require(`@/assets/images/client/client-4.png`),
                    name: 'Jone sone',
                    sellingAmount: '$2000,000',
                    topSince: '7 days',
                    status: 'varified',
                    products: ''
                },
                {
                    id: 5,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-5.png`),
                    name: 'Siddhart',
                    sellingAmount: '$200,000',
                    topSince: '15 days',
                    status: 'top rated',
                    products: ''
                },
                {
                    id: 6,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-6.png`),
                    name: 'Sobuj Mk',
                    sellingAmount: '$2000,000',
                    topSince: '7 days',
                    status: 'top rated',
                    products: ''
                },
                {
                    id: 7,
                    isVerified: true,
                    image: require(`@/assets/images/client/client-7.png`),
                    name: 'Trodband',
                    sellingAmount: '$2500,000',
                    topSince: '30 days',
                    status: 'varified',
                    products: ''
                },
                {
                    id: 8,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-8.png`),
                    name: 'Yash',
                    sellingAmount: '$2500,000',
                    topSince: '7 days',
                    status: 'top rated',
                    products: ''
                },
                {
                    id: 9,
                    isVerified: true,
                    image: require(`@/assets/images/client/client-9.png`),
                    name: 'YASHKIB',
                    sellingAmount: '$2500,000',
                    topSince: '30 days',
                    status: 'varified',
                    products: ''
                },
                {
                    id: 10,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-10.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '7 days',
                    status: 'top rated',
                    products: ''
                },
                {
                    id: 11,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-11.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '7 days',
                    status: 'top rated',
                    products: ''
                },
                {
                    id: 12,
                    isVerified: true,
                    image: require(`@/assets/images/client/client-12.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '30 days',
                    status: 'varified',
                    products: ''
                },
                {
                    id: 13,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-13.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '7 days',
                    status: 'top rated',
                    products: ''
                },
                {
                    id: 14,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-14.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '30 days',
                    status: 'best seller',
                    products: ''
                },
                {
                    id: 15,
                    isVerified: true,
                    image: require(`@/assets/images/client/client-15.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '1 day',
                    status: 'varified',
                    products: ''
                },
                {
                    id: 16,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-1.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '1 day',
                    status: 'best seller',
                    products: ''
                },
                {
                    id: 17,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-2.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '1 day',
                    status: 'best seller',
                    products: ''
                },
                {
                    id: 18,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-3.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '1 day',
                    status: 'best seller',
                    products: ''
                },
                {
                    id: 19,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-4.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '1 day',
                    status: 'recent added',
                    products: ''
                },
                {
                    id: 20,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-5.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '1 day',
                    status: 'recent added',
                    products: ''
                },
                {
                    id: 21,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-6.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '1 day',
                    status: 'recent added',
                    products: ''
                },
                {
                    id: 22,
                    isVerified: true,
                    image: require(`@/assets/images/client/client-7.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '1 day',
                    status: 'varified',
                    products: ''
                },
                {
                    id: 23,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-8.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '1 day',
                    status: 'recent added',
                    products: ''
                },
                {
                    id: 24,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-9.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '30 days',
                    status: 'recent added',
                    products: ''
                },
                {
                    id: 25,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-1.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '7 days',
                    status: 'recent added',
                    products: ''
                },
                {
                    id: 26,
                    isVerified: true,
                    image: require(`@/assets/images/client/client-10.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '30 days',
                    status: 'varified',
                    products: ''
                },
                {
                    id: 27,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-11.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '15 days',
                    status: 'recent added',
                    products: ''
                },
                {
                    id: 28,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-12.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '15 days',
                    status: 'recent added',
                    products: ''
                },
                {
                    id: 29,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-13.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '7 days',
                    status: 'recent added',
                    products: ''
                },
                {
                    id: 30,
                    isVerified: false,
                    image: require(`@/assets/images/client/client-14.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '15 days',
                    status: 'recent added',
                    products: ''
                },
                {
                    id: 31,
                    isVerified: true,
                    image: require(`@/assets/images/client/client-15.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '15 days',
                    status: 'varified',
                    products: ''
                },
                {
                    id: 32,
                    isVerified: true,
                    image: require(`@/assets/images/client/client-5.png`),
                    name: 'Brodband',
                    sellingAmount: '$2500,000',
                    topSince: '7 days',
                    status: 'varified',
                    products: ''
                }
            ]
        }
    },
    created() {
        this.authorProducts.onSale = this.products.slice().reverse();
        this.authorProducts.owned = this.products.sort(() => Math.random() - 0.5);
        this.authorProducts.created = this.products;
        this.authorProducts.liked = this.products.slice().reverse();

        this.authors.forEach(author => {
           author.products = this.authorProducts;
        });
    }
}