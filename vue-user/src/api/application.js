import request from "@/utils/request"

export default{

    // get a list of decided applications (status: admitted, rejected)
    getDecidedApplications() {
        return request(({
            url: `/api/application/public/get-decided-applications`,
            method: 'get'
        }))
    }

}
