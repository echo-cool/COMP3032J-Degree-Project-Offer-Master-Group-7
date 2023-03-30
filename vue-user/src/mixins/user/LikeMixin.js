import profileApi from "@/api/profile";


export default {
    data() {
        return{
            likedPrograms: [],
            likedProgramIds: [],

        }
    },

    created() {

    },

    methods:{
        // get a list of ids of programs that the user liked
        getLikedPrograms(){
            // reset the lists to empty
            this.likedPrograms = [];
            this.likedProgramIds = [];
            profileApi.getLikedPrograms()
                .then(response => {
                    // update the liked programs
                    this.likedPrograms = response.data.likedPrograms;
                    // create the list of program id
                    for (let k in this.likedPrograms){
                        this.likedProgramIds.push(this.likedPrograms[k].id);
                    }
                })
        },

        // whether the user liked a program
        isLiked(programId){
            return {
                isLiked: this.likedProgramIds.includes(programId)
            };
        },

        // remove program id from likedProgramsIds list (do not update likedPrograms list)
        removeLike(programId){
            this.likedProgramIds.splice(this.likedProgramIds.indexOf(programId), 1);
        },

        // add program id into likedProgramsIds list (do not update likedPrograms list)
        addLike(programId){
            this.likedProgramIds.push(programId);
        }
    }
}
