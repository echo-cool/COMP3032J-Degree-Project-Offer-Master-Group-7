<template>
    <div class="vedio-area rn-section-gapTop">
        <div class="container">
            <div class="row mb--40">
                <div class="title-area text-center">
                    <h3 class="title mb--15">Meet with Nuron</h3>
                    <p class="subtitle">
                        An NFT is a digital asset that represents real-world objects like art, music, in-game items
                        and videos. They are bought and sold online.
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-12 position-relative">
                    <a id="play-video"
                       class="video-play-button btn-large with-animation"
                       href="#"
                       @click.prevent="playVideo">
                        <span/>
                    </a>

                    <!-- Start vedio image wrapper -->
                    <div class="vedio-wrapper">
                        <img :src="require(`@/assets/images/bg/bg-image-21.jpg`)" alt="Video thumbnail">
                    </div>
                    <!-- End vedio image wrapper -->

                    <div id="video-overlay" class="video-overlay" @click="closeVideo">
                        <a class="video-overlay-close" @click.prevent="closeVideo">×</a>
<!--                        <iframe
                            width="60%"
                            height="80%"
                            :src="videoUrl"
                            frameborder="0"
                            allowfullscreen
                        />-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'VideoStyleOne',
        props: {
            videoUrl: {
                type: String
            }
        },
        methods: {
            playVideo() {
                const videoOverlay = document.querySelector('#video-overlay');
                let iframeElement = document.createElement('iframe');

                iframeElement.setAttribute('src', this.videoUrl);
                iframeElement.style.width = '60%';
                iframeElement.style.height = '80%';

                videoOverlay?.classList.add('open');
                videoOverlay.appendChild(iframeElement);
            },
            closeVideo() {
                const videoOverlay = document.querySelector('#video-overlay.open'),
                    iframeElement = document.querySelector('#video-overlay.open iframe');

                videoOverlay?.classList.remove('open');
                iframeElement.remove();
            }
        }
    }
</script>