<template>
    <layout>
        <breadcrumb title="GPA Converting" current="GPA Converting"/>

        <div class="rn-product-area rn-section-gapTop">
            <div class="container">
                <div class="row g-5">

                    <form-wizard>

                        <!-- step 1 -->
                        <tab-content title="Select Original GPA Scale" :before-change="beforeChange1">
                            <div class="about-market-area rn-section-gapTop">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="about-wrapper text-center">
                                                <h1>Your Original GPA Scale</h1>
                                                <p class="discription">
                                                    You need to specify the original scale of your GPA. Our GPA converting tool will
                                                    then convert your GPA into U.S. 4.0 scale using different algorithms according to
                                                    the original scale you selected here.
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="input-two-wrapper">
                                <div class="half-wid">
                                    <select id="original-scale" class="profile-edit-select mt--0" v-model="originalScale">
                                        <option value="" disabled selected style="display: none">Select your original GPA Scale here</option>
                                        <option value="UCD">University College Dublin 4.2 scale</option>
                                        <option value="CHINA">Chinese 0 - 100 scale</option>
                                    </select>
                                </div>
                            </div>
                        </tab-content>

                        <!-- step 2 -->
                        <tab-content title="Download and Fill Transcript Template" :before-change="beforeChange2">
                            <div class="about-market-area rn-section-gapTop">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="about-wrapper text-center">
                                                <h1>Download and Fill in Our Transcript Template</h1>
                                                <p class="discription">
                                                    You can download the our Transcript Template here, which is an Excel file.
                                                    You should input the information of all the courses you have taken, including
                                                    the course name, credit hours and your grade. Each row is for a single course.
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <a href="/backend/static/excel/GPA_Convert_Template.xlsx" class="btn btn-primary button-area w-25" style="display: block; margin: 0 auto">Download Template</a>
                        </tab-content>

                        <!-- step 3 -->
                        <tab-content title="Upload Your Filled Transcript" :before-change="beforeChange3">
                            <div class="about-market-area rn-section-gapTop">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="about-wrapper text-center">
                                                <h1>Upload Your Course-by-Course Transcript</h1>
                                                <p class="discription">
                                                    After filling in our Transcript Template, you can upload it here for GPA converting.
                                                    The file you upload should still be an Excel file with the extension of ".xlsx".
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <VueFileAgent v-model="fileRecords"
                                          :multiple="false"
                                          :meta="true"
                                          :accept="`.xlsx`"
                                          :helpText="'Upload your filled-in Excel Transcript Template'"
                                          @change="getFile($event)"></VueFileAgent>

                            <a v-if="this.fileUploaded" class="btn btn-danger button-area w-25" style="display: block; margin: 0 auto" @click="removeTranscript()">Remove File</a>
                            <a v-else class="btn btn-primary button-area w-25" style="display: block; margin: 0 auto" @click="uploadTranscript()">Upload Transcript</a>

                            <!-- show course grades in table -->
                            <div v-if="this.fileUploaded" class="container">
                                <div class="row">
                                    <div class="col-12">
                                        <div class="about-wrapper text-center">
                                            <h3>Following courses and grades are recognized from your transcript</h3>
                                        </div>
                                    </div>
                                </div>

                                <div class="box-table table-responsive">
                                    <table class="table upcoming-projects">
                                        <thead>
                                        <tr>
                                            <template v-for="(th, thIndex) in tableHeader" :key="`th-${thIndex}`">
                                                <th>
                                            <span class="text-capitalize">
                                                {{ th }}
                                            </span>
                                                </th>
                                            </template>
                                        </tr>
                                        </thead>

                                        <tbody class="ranking">
                                        <tr :class="{'color-light': rowIndex%2 === 0}"
                                            v-for="(row, rowIndex) in this.gradeRows"
                                            :key="`grade-row-${rowIndex}`">
                                            <td>
                                                <span>{{ rowIndex }}</span>
                                            </td>
                                            <td>
                                                <span>{{ row.courseName }}</span>
                                            </td>
                                            <td>
                                                <span>{{ row.grade }}</span>
                                            </td>
                                            <td>
                                                <span>{{ row.credits }}</span>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </tab-content>

                        <!-- step 4 -->
                        <tab-content title="Your Converted GPA in 4.0 Scale" :before-change="beforeChange4">
                            <div class="about-market-area rn-section-gapTop">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="about-wrapper text-center">
                                                <h1>Here to Download Your GPA Converting Report!</h1>
                                                <p class="discription">
                                                    Your GPA has been converted to the U.S 4.0 scale according to your original GPA scale
                                                    and the transcript you uploaded. GPA in your application background in OfferMaster is also updated!
                                                    The following table shows your course-by-course converting analysis.
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- show course grades in table -->
                            <div v-if="this.fileUploaded" class="container">
                                <div class="box-table table-responsive">
                                    <table class="table upcoming-projects">
                                        <thead>
                                        <tr>
                                            <template v-for="(th, thIndex) in tableHeader2" :key="`th2-${thIndex}`">
                                                <th>
                                            <span class="text-capitalize">
                                                {{ th }}
                                            </span>
                                                </th>
                                            </template>
                                        </tr>
                                        </thead>

                                        <tbody class="ranking">
                                        <tr :class="{'color-light': rowIndex%2 === 0}"
                                            v-for="(row, rowIndex) in this.gradeRows"
                                            :key="`grade-row2-${rowIndex}`">
                                            <td>
                                                <span>{{ rowIndex }}</span>
                                            </td>
                                            <td>
                                                <span>{{ row.courseName }}</span>
                                            </td>
                                            <td>
                                                <span>{{ row.credits }}</span>
                                            </td>
                                            <td>
                                                <span>{{ row.grade }}</span>
                                            </td>

                                            <td>
                                                <span>{{ row.gradeUS }}</span>
                                            </td>
                                            <td>
                                                <span>{{ row.gradePointUS }}</span>
                                            </td>

                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>

                            <!-- download report -->
                            <div class="row">
                                <div class="col-12">
                                    <div class="about-wrapper text-center">
                                        <h3>Here to download your course-by-course GPA converting report</h3>
                                    </div>
                                </div>
                            </div>
                            <a :href="`/backend/${this.reportDownloadURL}`" class="btn btn-primary button-area w-25" style="display: block; margin: 0 auto">Download GPA Converting Report</a>

                        </tab-content>
                    </form-wizard>

                </div>
            </div>
        </div>


    </layout>
</template>

<script>
    import Layout from '@/components/layouts/Layout'
    import Breadcrumb from '@/components/breadcrumb/Breadcrumb'

    import cookie from "js-cookie";
    import router from "@/router";
    import Toastify from "toastify-js";

    import GPAConvertApi from "@/api/GPAconvert";


    //local registration
    import {FormWizard, TabContent} from 'vue3-form-wizard'
    import 'vue3-form-wizard/dist/style.css'


    export default {
        name: 'GPAConverting',
        components: {
            Breadcrumb,
            Layout,
            FormWizard,
            TabContent
        },
        mixins: [],
        data() {
            return {
                originalScale: "",
                fileRecords: [],
                fileForUpload: null,
                fileUploaded: false,
                gradeRows: [],
                convertedGPA: null,
                tableHeader:[
                    " ",
                    "Course Name",
                    "Original Grade",
                    "Credits / Hours"
                ],
                tableHeader2:[
                    " ",
                    "Course Name",
                    "Credits / Hours",
                    "Original Grade",
                    "U.S. Grade",
                    "U.S. Grade Points"

                ],
                reportDownloadURL: ""
            }
        },
        created() {
            // load the current user info as this page is created
            // user would be redirected to the login page if not logged in
            this.getCurrentUser();

        },
        computed: {

        },
        methods: {
            notification(text){
                Toastify({
                    text: text,
                    duration: 3000,
                    close: false,
                    // avatar:"/img/logo-dark.44b49d43.png",
                    gravity: "top", // `top` or `bottom`
                    position: "right", // `left`, `center` or `right`
                    stopOnFocus: false, // Prevents dismissing of toast on hover
                    style: {
                        "font-size": "large",
                        "font-family":"\"Roboto\", sans-serif",
                        background: "linear-gradient(to right, #00b09b, #96c93d)",
                    },
                    onClick: function(){} // Callback after click
                }).showToast();
            },

            // get current user info from cookie
            getCurrentUser(){
                // we have stored this when logging in
                let userStr = cookie.get("current_user");
                // turn json string to json obj
                if (userStr){
                    this.currentUser = JSON.parse(userStr);

                }else{
                    // user should be redirected to the login page if not logged in
                    this.notification("You should login first!");
                    // window.alert("You should login first!");
                    router.push({path: '/login'});
                }
            },

            // select original GPA scale
            beforeChange1(){
                if (this.originalScale === "UCD" || this.originalScale === "CHINA"){
                    return true;
                }else{
                    this.notification("You should select your original GPA scale before next step!")
                    return false;
                }
            },

            // download template
            beforeChange2(){
                console.log("before change 2");
                return true;

            },

            // upload transcripts
            beforeChange3(){
                if (this.fileUploaded){
                    return true;
                }else{
                    this.notification("You should select your Excel transcript and upload!");
                    return false;
                }
            },

            beforeChange4(){
                console.log("before change 4");
                return true;

            },

            uploadTranscript() {
                // if no file chosen
                if (this.fileForUpload === null){
                    this.notification("You should select your Excel transcript and upload!");
                    return;
                }

                // encapsulate the Excel file and GPA scale into a form obj
                let formData = new FormData();
                formData.append("file", this.fileForUpload);
                formData.append('originalScale', this.originalScale);

                GPAConvertApi.convertGPA(formData)
                    .then(response => {
                        if (response.success) {
                            this.fileUploaded = true;
                            this.notification("Transcript uploaded!");
                            // update the data from response
                            this.gradeRows = response.data.gradeRows;
                            this.convertedGPA = response.data.convertedGPA;
                            this.reportDownloadURL = response.data.reportURL;

                        } else {
                            this.fileUploaded = false;
                            this.notification(response.message);
                        }
                    })

            },

            getFile(e) {
                if (e.target.files && e.target.files.length > 0) {
                    // update the file for uploading
                    this.fileForUpload = e.target.files[0];
                    this.fileUploaded = false;
                    this.reportDownloadURL = "";
                }
            },

            removeTranscript(){
                this.fileUploaded = false;
                this.fileForUpload = null;
                this.fileRecords = [];
                this.reportDownloadURL = "";
            }
        }
    }
</script>
