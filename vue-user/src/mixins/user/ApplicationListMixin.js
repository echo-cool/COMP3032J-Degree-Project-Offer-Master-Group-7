import profileApi from "@/api/profile";
import cookie from "js-cookie";
import router from "@/router";

export default {
    data() {
        return{
            applications: [
                {
                    id: "",
                    eStatus: "",
                    deadline: "",
                    degree: null,
                    program:{
                        id: "",
                        name: "",
                        school:{
                            id: "",
                            name: "",
                            img: ""
                        }
                    }
                }
            ]
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
                    this.applications = response._embedded.applications;

                    // for each of the application, send request to get the program info
                    for (let k in this.applications) {
                        // create the request url for this program
                        let programURL = `/rest/applications/${this.applications[k].id}/program`;
                        // call api method
                        profileApi.getByRestURL(programURL)
                            .then(response => { // response is the program

                                // update the program of this application
                                this.applications[k].program = response;

                                // create the request url for the school of this program
                                let schoolURL = `/rest/programs/${this.applications[k].program.id}/school`;

                                // send request to update the school info of this program
                                profileApi.getByRestURL(schoolURL)
                                    .then(response => { // response is the school

                                        // update the school of this program
                                        this.applications[k].program.school = response;

                                    })

                            })
                    }

                })
        }
    }
}
