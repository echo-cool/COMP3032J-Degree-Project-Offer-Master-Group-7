<template>
    <h2 class="text-left mb--50">OUR All NFT'S</h2>
    <nav class="product-tab-nav">
        <div class="nav" id="nav-tab" role="tablist">
            <button :class="[`nav-link`, {'active': activeTabIndex === index}]"
                    :id="`nav-${filterName(navLink.name)}-tab`"
                    data-bs-toggle="tab"
                    :data-bs-target="`#nav-${filterName(navLink.name)}`"
                    type="button"
                    role="tab"
                    :aria-controls="`nav-${filterName(navLink.name)}`"
                    :aria-selected="index === activeTabIndex ? 'true' : 'false'"
                    v-for="(navLink, index) in listItemsTab"
                    :key="`nav-link-${index}`">
                {{ navLink.name }}
            </button>
        </div>
    </nav>
    <div class="tab-content" id="nav-tabContent">
        <div :class="[`lg-product_tab-pane tab-pane fade`, {'show active': activeTabIndex === index}, {'lg-product-col-2': isTwoColumn}]"
             :id="`nav-${filterName(tabPane.name)}`"
             role="tabpanel"
             :aria-labelledby="`nav-${filterName(tabPane.name)}-tab`"
             v-for="(tabPane, index) in listItemsTab"
             :key="`nav-link-${index}`">
            <template v-for="(product, index) in tabPane.items"
                      :key="`product-${index}`">
                <product-list-card :product-date="product" :show-two-column="isTwoColumn"/>
            </template>
        </div>
    </div>
</template>

<script>
    import ProductMixin from '@/mixins/ProductMixin'
    import ProductListCard from '@/components/product/ProductListCard'

    export default {
        name: 'ExploreListStyle',
        components: {ProductListCard},
        mixins: [ProductMixin],
        props: {
            isTwoColumn: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
                activeTabIndex: 0,
                listItemsTab: [
                    {
                        name: 'All Product',
                        items: ''
                    },
                    {
                        name: 'Newest Item',
                        items: ''
                    },
                    {
                        name: 'Rare Reals',
                        items: ''
                    }
                ]
            }
        },
        methods: {
            filterName(name) {
                return name.toLowerCase().replace(' ', '-')
            }
        },
        mounted() {
            this.filterName('All Products')
        },
        created() {
            this.listItemsTab.forEach((item, index) => {
                if (index === 1) {
                    item.items = this.products.slice().reverse();
                } else if (index === 2) {
                    item.items = this.products.sort(() => Math.random() - 0.5);
                } else {
                    item.items = this.products;
                }
            });
        }
    }
</script>