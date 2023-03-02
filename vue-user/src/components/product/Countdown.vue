<template>
    <div class="countdown">
        <div class="countdown-container days">
            <span class="countdown-value">{{ twoDigits(days) }}</span>
            <span class="countdown-heading">D's</span>
        </div>
        <div class="countdown-container hours">
            <span class="countdown-value">{{ twoDigits(hours) }}</span>
            <span class="countdown-heading">H's</span>
        </div>
        <div class="countdown-container minutes">
            <span class="countdown-value">{{ twoDigits(minutes) }}</span>
            <span class="countdown-heading">Min's</span>
        </div>
        <div class="countdown-container seconds">
            <span class="countdown-value">{{ twoDigits(seconds) }}</span>
            <span class="countdown-heading">Sec</span>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Countdown',
        props: {
            date: null
        },
        data() {
            return {
                now: Math.trunc((new Date()).getTime() / 1000),
                event: new Date(`${this.date}T16:37:00`),
                finish: false
            }
        },
        computed: {
            secondCount () {
                return this.calculatedDate - this.now
            },
            calculatedDate () {
                return Math.trunc(Date.parse(this.event) / 1000)
            },
            seconds () {
                if (this.secondCount < 0) return 0
                return this.secondCount % 60
            },
            minutes () {
                if (this.secondCount < 0) return 0
                return Math.trunc(this.secondCount / 60) % 60
            },
            hours () {
                if (this.secondCount < 0) return 0
                return Math.trunc(this.secondCount / 60 / 60) % 24
            },
            days () {
                if (this.secondCount < 0) return 0
                return Math.trunc(this.secondCount / 60 / 60 / 24)
            }
        },
        methods: {
            twoDigits (value) {
                if (value.toString().length <= 1) {
                    return '0' + value.toString();
                }
                return value.toString();
            }
        },
        mounted () {
            const _self = this;
            window.setInterval(() => {
                this.now = Math.trunc((new Date()).getTime() / 1000)
                if (!this.finish && this.calculatedDate - this.now <= 0) {
                    _self.finish = true
                    _self.$emit('onFinish')
                }
            }, 1000);
        },
    }
</script>