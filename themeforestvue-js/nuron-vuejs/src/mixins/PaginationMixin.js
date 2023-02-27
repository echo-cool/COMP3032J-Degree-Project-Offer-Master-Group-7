import BlogMixin from '@/mixins/BlogMixin'

export default {
    mixins: [BlogMixin],
    data() {
        return {
            rows: '',
            countOfPage: 8,
            currPage: 1
        }
    },
    computed: {
        filteredRows() {
            return this.rows;
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
            if(idx <= 0 || idx > this.totalPage) {
                return;
            }
            this.currPage = idx;
        },
    },
    mounted() {
        this.rows = this.posts
    }
}