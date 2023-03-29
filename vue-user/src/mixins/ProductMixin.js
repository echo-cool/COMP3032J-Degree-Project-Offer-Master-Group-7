import schoolApi from "@/api/shool";

export default {
    data() {
        return {
            products: [
                {
                    "id": 1,
                    "name": "",
                    "img": "",
                    "rankQS": 1,
                    "rankUSNews": 1,
                    "programs": [
                        {
                            "id": 1,
                            "name": "",
                            "degree": "",
                            "major": "",
                            "likes": 0,
                            "applications": []
                        }
                    ]
                }
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
