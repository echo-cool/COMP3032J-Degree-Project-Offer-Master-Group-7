<template>
    <layout>
        <breadcrumb title="Upload Variants" current="Upload Variants"/>

        <div class="rn-upload-variant-area varient rn-section-gap">
            <div class="container">
                <div class="row">
                    <div class="upload-variant-title-wrapper">
                        <h3 class="title text-center">
                            Upload Variants
                        </h3>
                        <p class="text-center">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ducimus inventore, officiis. Alias
                            aspernatur laboriosam ratione! Doloremque ipsa nesciunt sed!
                        </p>
                    </div>
                </div>
                <div class="row g-5 mt--40">
                    <div class="offset-lg-3 col-lg-3 col-md-6 col-12">
                        <div class="upload-variant-wrapper">
                            <div class="variant-preview">
                                <img :src="require(`@/assets/images/upload-variants/single.jpg`)" alt="nuron-single">
                            </div>
                            <router-link to="/create" class="btn btn-primary mt--20">Create Single</router-link>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-12">
                        <div class="upload-variant-wrapper">
                            <div class="variant-preview">
                                <img :src="require(`@/assets/images/upload-variants/multiple.jpg`)" alt="nuron-single">
                            </div>
                            <router-link to="/create" class="btn btn-primary mt--20">Create Multiple</router-link>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'

    export default {
        name: 'UploadVariants',
        components: {Breadcrumb, Layout}
    }
</script>