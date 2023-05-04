<template>
    <div class="range-slider">
        <Slider
            v-model="value"
            :tooltips="false"
            @update="handleUpdate"
            range :max="400.00"
        />
        <div class="slider__range--output">
            <div class="price__output--wrap">
                <div class="price--output">
                    <span>
<!--                        GPA : <span class="ms-1">{{ value[0] }} - {{ value[1] }}</span>-->
                        GPA : <span class="ms-1">{{ value[0]/100 }} - {{ value[1]/100 }}</span>
                    </span>
                </div>
                <div v-if="showFilterButton" class="price--filter">
                    <a class="btn btn-primary btn-small"
                       href="#"
                       @click.prevent="$emit('filterPrice')">
                        Filter
                    </a>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import Slider from '@vueform/slider'
    import '@vueform/slider/themes/default.css'

    export default {
        name: 'RangeSlider',
        props: {
            showFilterButton: {
                type: Boolean,
                default: true
            }
        },
        components: {Slider},
        data() {
            return {
                value: [300.00, 400.00]
            }
        },
        methods: {
            handleUpdate() {
                // if (!this.showFilterButton) {
                //     this.$emit('filterPrice');
                // }
                this.$emit('onChangeRange', this.value);
            }
        }
    }
</script>
