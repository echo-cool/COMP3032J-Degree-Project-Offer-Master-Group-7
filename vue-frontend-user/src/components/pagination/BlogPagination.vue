<template>
    <nav v-if="posts.length > 8"
         class="pagination-wrapper"
         aria-label="Page navigation example">
        <ul :class="`pagination ${paginationClass}`">
            <li class="page-item"
                :class="{'disabled': (currPage === 1)}"
                @click.prevent="setPage(currPage-1)">
                <a class="page-link" href="">
                    Previous
                </a>
            </li>
            <li class="page-item"
                v-for="n in totalPage"
                @click.prevent="setPage(n)">
                <a :class="[`page-link`, {'active': (currPage === (n))}]" href="">
                    {{ n }}
                </a>
            </li>
            <li class="page-item"
                :class="{'disabled': (currPage === totalPage)}"
                @click.prevent="setPage(currPage + 1)">
                <a class="page-link" href="">
                    Next
                </a>
            </li>
        </ul>
    </nav>
</template>

<script>
    export default {
        name: 'BlogPagination',
        props: {
            posts: {},
            countOfPage: {
                type: Number,
                default: 8
            },
            paginationClass: {
                type: String
            },
            scrollControl: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
                currPage: 1
            }
        },
        computed: {
            filteredRows() {
                return this.posts;
            },
            pageStart() {
                return (this.currPage - 1) * this.countOfPage;
            },
            totalPage() {
                return Math.ceil(this.filteredRows.length / this.countOfPage);
            }
        },
        methods: {
            setPage(idx) {
                if (idx <= 0 || idx > this.totalPage) {
                    return;
                }
                this.currPage = idx;
                if (this.scrollControl) {
                    this.$emit('scrollControl');
                } else {
                    window.scrollTo(0, 0);
                }
                this.$emit('paginatedData', this.filteredRows, this.pageStart, this.countOfPage);
            },
        },
        mounted() {
            this.$emit('paginatedData', this.filteredRows, this.pageStart, this.countOfPage)
        }
    }
</script>
