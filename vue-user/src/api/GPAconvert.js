import request from "@/utils/request"

export default{

    downloadTemplate(){
        return request({
            url: `/api/gpa-convert/download-template`,
            method: 'get'
        })
    },

}
