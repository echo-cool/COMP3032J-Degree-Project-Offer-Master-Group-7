import profileApi from "@/api/profile";
import commonApi from "@/api/common";
import cookie from "js-cookie";
import router from "@/router";

export default {
    data() {
        return{
            applications: [],
            selectedProgramIDs: [],
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

                    // update the program ID list
                    this.selectedProgramIDs = [];
                    for (let k in this.applications){
                        this.selectedProgramIDs.push(this.applications[k].program.id);
                    }

                    // for test
                    console.log("selectedProgramIDs: " + this.selectedProgramIDs);

                })
        }
    }
}
