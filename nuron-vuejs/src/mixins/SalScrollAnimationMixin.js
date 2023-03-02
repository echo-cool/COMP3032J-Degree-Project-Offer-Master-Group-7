import sal from 'sal.js'

export default {
    mounted() {
        sal({
            threshold: 0.1,
            once: true
        });
    }
}