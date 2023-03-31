<template>
    <layout>
        <breadcrumb title="Crete a New File" current="Crete a New File"/>

        <div class="create-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">
                  <form class="row" action="#" onsubmit="return false" id="post-form">
                    <div class="col-lg-3 offset-1 ml_md--0 ml_sm--0">
                        <!-- Start file Upload Area -->
                        <div class="upload-area">
                            <div class="upload-formate mb--30">
                                <h6 class="title">
                                    Upload Image
                                </h6>
                                <p class="formate">
                                    Drag or choose your image to upload
                                </p>
                            </div>
                            <div class="brows-file-wrapper">
                                <input
                                    id="file"
                                    name="image"
                                    accept="image/*"
                                    type="file"
                                    class="inputfile"
                                    @change="imageChange"
                                />
                                <img
                                    v-if="selectedImage"
                                    id="createfileImage"
                                    :src="selectedImage"
                                    alt=""
                                    data-black-overlay="6"
                                />
                                <label for="file" title="No File Choosen">
                                    <i class="feather-upload"/>
                                    <span class="text-center">Choose a File</span>
                                    <p class="text-center mt--10">
                                        PNG, GIF, WEBP, MP4 or MP3.{" "} <br/> Max 1Gb.
                                    </p>
                                </label>
                            </div>
                        </div>
                        <!-- End File Upload Area -->
                    </div>

                    <div class="col-lg-7">
                        <div class="form-wrapper-one">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="input-box pb--20">
                                        <label for="title" class="form-label">Title</label>
                                        <input id="title" name="title" placeholder="">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                  <div class="input-box pb--20">
                                    <label for="category" class="form-label">Category</label>
                                    <div class="input-two-wrapper">
                                      <select id="category" name="category" class="profile-edit-select mt--0">
                                        <option v-for="category in categories" :value="category.name">{{ category.name }}</option>
                                      </select>
                                    </div>
                                  </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="input-box pb--20">
                                        <label for="Content" class="form-label">Content</label>
                                          <div style="border: 1px solid #ccc">
                                            <Toolbar
                                                style="border-bottom: 1px solid #ccc"
                                                :editor="editorRef"
                                                :defaultConfig="toolbarConfig"
                                                :mode="mode"
                                            />
                                            <Editor
                                                id="Content"
                                                name="content"
                                                style="height: 500px; overflow-y: hidden;"
                                                v-model="valueHtml"
                                                :defaultConfig="editorConfig"
                                                :mode="mode"
                                                @onCreated="handleCreated"
                                            />
                                          </div>
                                    </div>
                                </div>
<!--                                <div class="col-md-4">-->
<!--                                    <div class="input-box pb&#45;&#45;20">-->
<!--                                        <label for="dollerValue" class="form-label">Item Price in $</label>-->
<!--                                        <input id="dollerValue" placeholder="e. g. `20$`">-->
<!--                                    </div>-->
<!--                                </div>-->
<!--                                <div class="col-md-4">-->
<!--                                    <div class="input-box pb&#45;&#45;20">-->
<!--                                        <label for="Size" class="form-label">Size</label>-->
<!--                                        <input id="Size" placeholder="e. g. `Size`">-->
<!--                                    </div>-->
<!--                                </div>-->
<!--                                <div class="col-md-4">-->
<!--                                    <div class="input-box pb&#45;&#45;20">-->
<!--                                        <label for="Properties" class="form-label">Properties</label>-->
<!--                                        <input id="Properties" placeholder="e. g. `Properties`">-->
<!--                                    </div>-->
<!--                                </div>-->
<!--                                <div class="col-md-12">-->
<!--                                    <div class="input-box pb&#45;&#45;20">-->
<!--                                        <label for="Royality" class="form-label">Royality</label>-->
<!--                                        <input id="Royality" placeholder="e. g. `20%`">-->
<!--                                    </div>-->
<!--                                </div>-->
<!--                                <div class="col-md-4 col-sm-4">-->
<!--                                    <div class="input-box pb&#45;&#45;20 rn-check-box">-->
<!--                                        <input class="rn-check-box-input" type="checkbox" id="putonsale">-->
<!--                                        <label class="rn-check-box-label" for="putonsale">-->
<!--                                            Put on Sale-->
<!--                                        </label>-->
<!--                                    </div>-->
<!--                                </div>-->
<!--                                <div class="col-md-4 col-sm-4">-->
<!--                                    <div class="input-box pb&#45;&#45;20 rn-check-box">-->
<!--                                        <input class="rn-check-box-input" type="checkbox" id="instantsaleprice">-->
<!--                                        <label class="rn-check-box-label" for="instantsaleprice">-->
<!--                                            Instant Sale Price-->
<!--                                        </label>-->
<!--                                    </div>-->
<!--                                </div>-->
<!--                                <div class="col-md-4 col-sm-4">-->
<!--                                    <div class="input-box pb&#45;&#45;20 rn-check-box">-->
<!--                                        <input class="rn-check-box-input" type="checkbox" id="unlockpurchased">-->
<!--                                        <label class="rn-check-box-label" for="unlockpurchased">-->
<!--                                            Unlock Purchased-->
<!--                                        </label>-->
<!--                                    </div>-->
<!--                                </div>-->
                                <div class="col-md-12 col-xl-4">
                                    <div class="input-box">
                                        <button type="button" class="btn btn-primary-alta btn-large w-100"
                                                data-bs-toggle="modal" data-bs-target="#uploadModal">Preview
                                        </button>
                                    </div>
                                </div>
                                <div class="col-md-12 col-xl-8 mt_lg--15 mt_md--15 mt_sm--15">
                                    <div class="input-box">
                                        <button class="btn btn-primary btn-large w-100" v-on:click="submitEvent()">Submit Item</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mt--100 mt_sm--30 mt_md--30 d-block d-lg-none">
                        <h5> Note: </h5>
                        <span> Service fee : <strong>2.5%</strong> </span> <br>
                        <span> You will receive : <strong>25.00 ETH $50,000</strong></span>
                    </div>
                  </form>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="rn-popup-modal upload-modal-wrapper modal fade" id="uploadModal" tabindex="-1" aria-hidden="true">
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                <i class="feather-x"/>
            </button>
            <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                <div class="modal-content share-wrapper">
                    <div class="modal-body">
                        <product-card :product-date="product" product-style-class="no-overlay"/>
                    </div>
                </div>
            </div>
        </div>

        <share-modal/>

        <report-modal/>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
    import ProductCard from '@/components/product/ProductCard'
    import ShareModal from '@/components/modal/ShareModal'
    import ReportModal from '@/components/modal/ReportModal'

    import '@wangeditor/editor/dist/css/style.css' // 引入 css

    import { onBeforeUnmount, ref, shallowRef, onMounted } from 'vue'
    import { i18nChangeLanguage } from '@wangeditor/editor'
    import { Editor, Toolbar } from '@wangeditor/editor-for-vue'
    import request from "@/utils/request";
    import cookie from "js-cookie";
    import {getAllCategories} from "@/api/community";

    export default {
        name: 'CreatePost',
        components: {ReportModal, ShareModal, ProductCard, Breadcrumb, Layout, Editor, Toolbar},
        setup() {
          console.log("setup")
          i18nChangeLanguage('en')
          // 编辑器实例，必须用 shallowRef
          const editorRef = shallowRef()

          // 内容 HTML
          const valueHtml = ref('<p>Enter...</p>')

          // 模拟 ajax 异步获取内容
          onMounted(() => {
            setTimeout(() => {
              valueHtml.value = '<p></p>'
            }, 1500)
          })

          const toolbarConfig = {}
          const editorConfig = { placeholder: 'Enter...' }

          // 组件销毁时，也及时销毁编辑器
          onBeforeUnmount(() => {
            const editor = editorRef.value
            if (editor == null) return
            editor.destroy()
          })

          const handleCreated = (editor) => {
            editorRef.value = editor // 记录 editor 实例，重要！
          }

          function submitEvent() {
            let form = document.getElementById('post-form')
            let formData = new FormData(form)
            formData.append("content", editorRef.value.getHtml())
            request({
              url: '/api/post/createPost',
              method: 'post',
              data: formData
            }).then(response => {
              if (response['success'] === true) {
                window.location.href = "/community"
              }
            })

            return false
          }

          return {
            editorRef,
            valueHtml,
            mode: 'default', // 或 'simple'
            toolbarConfig,
            editorConfig,
            handleCreated,
            submitEvent
          };
        },
        data() {
            return {
                selectedImage: null,
                categories: [],
                product: {
                    id: 1,
                    productImage: require(`@/assets/images/portfolio/portfolio-01.jpg`),
                    authors: [
                        {
                            id: 1,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-1.png`)
                        },
                        {
                            id: 2,
                            name: 'Jone lee',
                            image: require(`@/assets/images/client/client-2.png`)
                        },
                        {
                            id: 3,
                            name: 'Nisat Tara',
                            image: require(`@/assets/images/client/client-3.png`)
                        }
                    ],
                    biddingAmount: '9',
                    productName: 'Preatent',
                    latestBid: 'Highest bid 1/20',
                    lastBid: '0.244wETH',
                    reacted: '322'
                }
            }
        },
      methods: {
            imageChange(e) {
                if (e.target.files && e.target.files.length > 0) {
                    const file = e.target.files[0];
                    this.selectedImage = URL.createObjectURL(file);
                }
            },
            // submitEvent() {
            //   let form = document.getElementById('post-form')
            //   let formData = new FormData(form)
            //   formData.append("content", this.valueHtml)
            //   request({
            //     url: '/api/post/createPost',
            //     method: 'post',
            //     data: formData
            //   }).then(response => {
            //       if (response['success'] === true) {
            //         window.location.href = "/community"
            //       }
            //   })
            //   return false
            // }
      },
      created() {
          getAllCategories().then(response => {
              this.categories = response["data"]["categories"]
          })
      }
    }
</script>