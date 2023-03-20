import request from "@/utils/request"

export default{

    // delete user application by id
    deleteApplicationById(appId){
        return request({
            url: `/rest/applications/${appId}`,
            method: 'delete'
        })
    },

    deleteApplicationByProgramId(programId){
        return request({
            url: `/api/application/deleteApplicationByProgramId/${programId}`,
            method: 'delete'
        })
    },

    addApplication(programId){
        return request({
            url: `/api/application/addApplication/${programId}`,
            method: 'post'
        })
    }

}
