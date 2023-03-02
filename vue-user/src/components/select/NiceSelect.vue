<template>
    <div :class="[`nice-select ${className}`, {'open': open}]"
         tabindex="0"
         @click.prevent="open = !open"
         role="button"
         ref="">
        <span class="current">{{ current?.text || placeholder }}</span>
        <ul class="list" role="menubar" @click.prevent="$event.stopPropagation()">
            <li :class="[`option`, {'selected focus': item.value === current.value}]"
                v-for="(item, index) in options"
                :key="`option-${index}`"
                @click.prevent="currentHandler(item, index)"
                role="menuitem">
                {{ item.text }}
            </li>
        </ul>
    </div>
</template>

<script>
    export default {
        props: {
            options: '',
            defaultCurrent: {},
            placeholder: {},
            className: {},
            name: {}
        },
        name: 'NiceSelect',
        data() {
            return {
                open: false,
                current: this.options[this.defaultCurrent],
            }
        },
        methods: {
            onClose() {
                this.open = false
            },
            currentHandler(item, index) {
                this.current = this.options[index];
                this.$emit('onChange', item)
                this.onClose()
            }
        }
    }
</script>