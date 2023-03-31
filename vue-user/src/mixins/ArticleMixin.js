export default {
    data() {
        return {
            articles: [
                {
                    id: 0,
                    // img: "",
                    createdAt: '',
                    title: '',
                    user: {id: 1, name: ""},
                    content: "",
                },
            ]
        }
    },

    // methods: {
    //     getSchools() {
    //         schoolApi.getAllSchools().then(response => {
    //             this.products = response['data']['schools']
    //             console.log(this.products)
    //         })
    //     }
    // }
}
