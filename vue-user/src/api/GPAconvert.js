import request from "@/utils/request"

export default{

    downloadTemplate(){
        return request({
            url: `/api/gpa-convert/download-template`,
            method: 'get'
        })
    },


    convertGPA(form){
        return request({
            url: `/api/gpa-convert/gpa-convert-excel-upload`,
            method: 'post',
            headers: {
                'Content-Type': 'multipart/form-data'
            },
            data: form
        })
    },
}
