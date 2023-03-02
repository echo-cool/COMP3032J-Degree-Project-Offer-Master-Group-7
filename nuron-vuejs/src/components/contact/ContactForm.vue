<template>
    <form class="rwt-dynamic-form" id="contact-form">
        <div class="mb-5">
            <label for="contact-name" class="form-label">Your Name</label>
            <input name="contact-name" id="contact-name" type="text" v-model="formData.name">
            <span v-if="v$.formData.name.$error" class="text-danger mt-2 d-inline-block">
                {{ v$.formData.name.$errors[0].$message }}
            </span>
        </div>
        <div class="mb-5">
            <label for="contact-email" class="form-label">Email</label>
            <input id="contact-email" name="contact-email" type="email" v-model="formData.email">
            <span v-if="v$.formData.email.$error" class="text-danger mt-2 d-inline-block">
                {{ v$.formData.email.$errors[0].$message }}
            </span>
        </div>
        <div class="mb-5">
            <label for="subject" class="form-label">Subject</label>
            <input id="subject" name="subject" type="text" v-model="formData.subject">
            <span v-if="v$.formData.subject.$error" class="text-danger mt-2 d-inline-block">
                {{ v$.formData.subject.$errors[0].$message }}
            </span>
        </div>
        <div class="mb-5">
            <label for="contact-message" class="form-label">Write Message</label>
            <textarea name="contact-message" id="contact-message" rows="3" v-model="formData.message"></textarea>
            <span v-if="v$.formData.message.$error" class="text-danger mt-2 d-inline-block">
                {{ v$.formData.message.$errors[0].$message }}
            </span>
        </div>
        <div class="mb-5 rn-check-box">
            <div>
                <input id="condition" type="checkbox" class="rn-check-box-input" v-model="formData.allowTerms">
                <label for="condition" class="rn-check-box-label">
                    Allow to all terms & condition
                </label>
            </div>
            <span v-if="v$.formData.allowTerms.$error" class="text-danger mt-2 d-inline-block">
                {{ v$.formData.allowTerms.$errors[0].$message }}
            </span>
        </div>
        <button name="submit" type="submit" class="btn btn-primary" @click.prevent="submitForm">Send Message</button>
        <p v-if="submitted" class="mt-4 font-14 text-success">Thanks! for being with us</p>
    </form>
</template>

<script>
    import axios from 'axios'
    import useVuelidate from '@vuelidate/core'
    import {required, email} from '@vuelidate/validators'

    export default {
        name: 'ContactForm',
        data() {
            return {
                v$: useVuelidate(),
                formData: {
                    name: '',
                    email: '',
                    subject: '',
                    message: '',
                    allowTerms: false
                },
                submitted: false
            }
        },
        validations() {
            return {
                formData: {
                    name: {required},
                    email: {required, email},
                    subject: {required},
                    message: {required},
                    allowTerms: {required}
                }
            }
        },
        methods: {
            submitForm() {
                this.v$.$validate();
                const data = this.formData;

                if (!this.v$.$error) {
                    axios({
                        method: 'post',
                        url: 'https://getform.io/f/7a6695a7-c8e3-442c-bc2f-d46d3b9a535e',
                        data,
                    }).then((_res) => {
                        this.submitted = true;
                        this.formData.name = '';
                        this.formData.email = '';
                        this.formData.subject = '';
                        this.formData.message = '';
                        this.formData.allowTerms = false;
                        this.v$.$reset()
                    }).catch((err) => {
                        console.log(err)
                    });
                } else {
                    console.log('Please fill up the required fields')
                }
            }
        }
    }
</script>