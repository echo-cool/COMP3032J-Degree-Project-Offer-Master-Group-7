import profileApi from "@/api/profile";
import commonApi from "@/api/common";
import cookie from "js-cookie";
import router from "@/router";

export default {
    data() {
        return{
            applications: [
            ],
        }
    },

    created() {

    },

    methods:{
        // get the applications (program list) of current user
        getApplications(uid){

            // call the api method
            profileApi.getApplicationsByUid(uid)
                .then(response => {

                    // update the programs list
                    this.applications = response.data.applications;

                })
        }
    }
}
