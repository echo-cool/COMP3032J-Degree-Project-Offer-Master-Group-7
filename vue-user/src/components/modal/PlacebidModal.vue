<template>
    <div class="rn-popup-modal placebid-modal-wrapper modal fade" id="placebidModal" tabindex="-1" aria-hidden="true">
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"><i class="feather-x"/></button>
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title">Available Programs</h3>
                </div>
                <div class="modal-body">
<!--                  <div v-for=""></div>-->
                  <ul>

                  <div class=""
                       v-for="(item, index) in programs"
                       :key="`newest-item-${index}`">
                      <a :href="`/program-details/`+item.id"><li class="program-item-class" style="text-decoration: underline;" >{{item.name}}</li></a>
                  </div>
                  </ul>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import request from "@/utils/request";

    export default {
        name: 'PlacebidModal',
      data() {
        return {
          programs:{}
        }
      },
      props: {
        id: {
          type: String,
          default: "1"
        }
      },
      created() {
          this.getData();
      },
      methods:{
          getData(){
            let that = this;
            request({
              url: `/api/program/public/getProgramsBySchool/` + that.id,
              method: 'get'
            }).then(function (res){
              console.log(res.data);
              that.programs = res.data.programs;
            });
          }
      }
    }
</script>
<style>
.program-item-class:hover{
  color: black;
}
</style>
