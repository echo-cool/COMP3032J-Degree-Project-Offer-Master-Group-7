<template>
    <div class="rn-progress-parent">
        <svg class="rn-back-circle svg-inner" width="100%" height="100%" viewBox="-1 -1 102 102">
            <path d="M50,1 a49,49 0 0,1 0,98 a49,49 0 0,1 0,-98"/>
        </svg>
    </div>
</template>

<script>
    export default {
        name: 'BackToTop',
        mounted() {
            const progressParent = document.querySelector('.rn-progress-parent'),
                  progressPath = document.querySelector('.rn-progress-parent path'),
                  pathLength = progressPath.getTotalLength();

            progressPath.style.transition = progressPath.style.WebkitTransition = 'none';
            progressPath.style.strokeDasharray = `${pathLength} ${pathLength}`;
            progressPath.style.strokeDashoffset = pathLength;
            progressPath.getBoundingClientRect();
            progressPath.style.transition = progressPath.style.WebkitTransition = 'stroke-dashoffset 10ms linear';

            const updateProgress = () => {
                const scroll = window.scrollY,
                      docHeight = document.body.offsetHeight,
                      winHeight = window.innerHeight,
                      height = docHeight - winHeight,
                      progress = pathLength - (scroll * pathLength) / height;
                progressPath.style.strokeDashoffset = progress;
            };

            updateProgress();
            window.addEventListener('scroll', updateProgress);

            let offset = 50;

            window.addEventListener('scroll', () => {
                if (window.scrollY > offset) {
                    progressParent.classList.add('rn-backto-top-active');
                } else {
                    progressParent.classList.remove('rn-backto-top-active');
                }
            });
        }
    }
</script>