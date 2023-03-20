import profileApi from "@/api/profile";

export default {

    // get the applications (program list) of current user
    getApplications(uid){
        // ajax 请求结束之前会先走到最后的return，所以返回空列表！！！

        let applications = [];

        // call the api method
        profileApi.getApplicationsByUid(uid)
            .then(response => {

                // update the programs list
                applications = response._embedded.applications;

                // for each of the application, send request to get the program info
                for (let k in applications) {
                    // create the request url for this program
                    let programURL = `/rest/applications/${applications[k].id}/program`;
                    // call api method
                    profileApi.getByRestURL(programURL)
                        .then(response => { // response is the program

                            // update the program of this application
                            applications[k].program = response;

                            // create the request url for the school of this program
                            let schoolURL = `/rest/programs/${applications[k].program.id}/school`;

                            // send request to update the school info of this program
                            profileApi.getByRestURL(schoolURL)
                                .then(response => { // response is the school

                                    // update the school of this program
                                    applications[k].program.school = response;

                                })

                        })
                }

            })

        return applications;
    }

}
