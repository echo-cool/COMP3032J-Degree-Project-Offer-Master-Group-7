<template>
    <div class="range-slider">
        <Slider
            v-model="value"
            :tooltips="false"
            @update="handleUpdate"
        />
        <div class="slider__range--output">
            <div class="price__output--wrap">
                <div class="price--output">
                    <span>
                        Price : <span class="ms-1">${{ value[0] }} - ${{ value[1] }}</span>
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
                value: [20, 40]
            }
        },
        methods: {
            handleUpdate() {
                if (!this.showFilterButton) {
                    this.$emit('filterPrice');
                }
                this.$emit('onChangeRange', this.value);
            }
        }
    }
</script>