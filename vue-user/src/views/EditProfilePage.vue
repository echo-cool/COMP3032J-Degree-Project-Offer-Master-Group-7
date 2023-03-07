<template>
    <layout>
        <breadcrumb title="Edit Profile" current="Edit Profile"/>

        <div class="edit-profile-area rn-section-gapTop">
            <div class="container">
                <div class="row plr--70 padding-control-edit-wrapper pl_md--0 pr_md--0 pl_sm--0 pr_sm--0">
                    <div class="col-12 d-flex justify-content-between mb--30 align-items-center">
                        <h4 class="title-left">Edit Your Profile</h4>
                        <router-link to="/author/1" class="btn btn-primary ml--10">
                            <i class="feather-eye mr--5"></i> Preview
                        </router-link>
                    </div>
                </div>
                <div class="row plr--70 padding-control-edit-wrapper pl_md--0 pr_md--0 pl_sm--0 pr_sm--0">
                    <div class="col-lg-3 col-md-3 col-sm-12">
                        <nav class="left-nav rbt-sticky-top-adjust-five">
                            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                <button class="nav-link active"
                                        id="nav-home-tab"
                                        data-bs-toggle="tab"
                                        data-bs-target="#nav-home"
                                        type="button"
                                        role="tab"
                                        aria-controls="nav-home"
                                        aria-selected="true">
                                    <i class="feather-edit"/> Edit Profile Image
                                </button>
                                <button class="nav-link"
                                        id="nav-home-tabs"
                                        data-bs-toggle="tab"
                                        data-bs-target="#nav-homes"
                                        type="button"
                                        role="tab"
                                        aria-controls="nav-homes"
                                        aria-selected="false">
                                    <i class="feather-user"/> Personal Information
                                </button>
                                <button class="nav-link"
                                        id="nav-background-tab"
                                        data-bs-toggle="tab"
                                        data-bs-target="#nav-application-background"
                                        type="button"
                                        role="tab"
                                        aria-controls="nav-application-background"
                                        aria-selected="false">
                                    <i class="feather-book-open"/> My Application Background
                                </button>
                                <button class="nav-link"
                                        id="nav-profile-tab"
                                        data-bs-toggle="tab"
                                        data-bs-target="#nav-profile"
                                        type="button"
                                        role="tab"
                                        aria-controls="nav-profile"
                                        aria-selected="false">
                                    <i class="feather-unlock"/> Change Password
                                </button>
                                <button class="nav-link"
                                        id="nav-contact-tab"
                                        data-bs-toggle="tab"
                                        data-bs-target="#nav-contact"
                                        type="button"
                                        role="tab"
                                        aria-controls="nav-contact"
                                        aria-selected="false">
                                    <i class="feather-bell"/> Notification Setting
                                </button>
                            </div>
                        </nav>
                    </div>
                    <div class="col-lg-9 col-md-9 col-sm-12 mt_sm--30">
                        <div class="tab-content tab-content-edit-wrapepr" id="nav-tabContent">

                            <!-- Avatar Panel -->
                            <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                                <div class="nuron-information">
                                    <div class="profile-change row g-5">
                                        <div class="profile-left col-lg-4">
                                            <div class="profile-image mb--30">
                                                <h6 class="title">Change Your Avatar</h6>
                                                <!-- That :src require() is fucking important!!! -->
                                                <!-- 1. it cannot totally be a variable, so we must concatenate the param like the following -->
                                                <!-- 2. for that @..., we must use the dir of /assets/images/profile/..., don't know why -->
                                                <!-- 3. this two <img> must use the same id here, because preview function would be called again -->
                                                <!-- after the user upload an avatar (no avatar -> has avatar) -->
                                                <img v-if="currentUser.avatar"
                                                     id="profilePicture"
                                                     :src="require(`@/assets/images/profile/upload/avatar/` + currentUser.avatar)"
                                                     alt="Profile-NFT"
                                                     @click="$refs.profileImageInput.click()">
                                                <img v-else
                                                     id="profilePicture"
                                                     :src="require(`@/assets/images/profile/profile-01.jpg`)"
                                                     alt="Profile-NFT"
                                                     @click="$refs.profileImageInput.click()">
                                            </div>
                                            <div class="button-area">
                                                <div class="brows-file-wrapper">
                                                    <input id="fatima"
                                                           type="file"
                                                           accept="image/*"
                                                           @change="previewImage($event, 'profilePicture')"
                                                           ref="profileImageInput">
                                                    <label for="fatima" title="No File Choosen">
                                                        <span class="text-center color-white">Upload Avatar</span>
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="profile-left right col-lg-8">
                                            <div class="profile-image mb--30">
                                                <h6 class="title">Change Your Cover Photo</h6>
                                                <img id="coverPhoto"
                                                     :src="require(`@/assets/images/profile/cover-01.jpg`)"
                                                     alt="Profile-NFT"
                                                     @click="$refs.coverPhotoInput.click()">
                                            </div>
                                            <div class="button-area">
                                                <div class="brows-file-wrapper">
                                                    <input id="nipa"
                                                           type="file"
                                                           @change="previewImage($event, 'coverPhoto')"
                                                           ref="coverPhotoInput">
                                                    <label for="nipa" title="No File Choosen">
                                                        <span class="text-center color-white">Upload Cover</span>
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Personal Info Panel -->
                            <div class="tab-pane fade" id="nav-homes" role="tabpanel" aria-labelledby="nav-home-tab">
                                <div class="nuron-information">
                                    <div class="profile-form-wrapper">
<!--                                        <div class="input-two-wrapper mb&#45;&#45;15">-->
<!--                                            <div class="first-name half-wid">-->
<!--                                                <label for="contact-name" class="form-label">First Name</label>-->
<!--                                                <input id="contact-name" type="text" value="Mr.">-->
<!--                                            </div>-->
<!--                                            <div class="last-name half-wid">-->
<!--                                                <label for="contact-name-last" class="form-label">Last Name</label>-->
<!--                                                <input id="contact-name-last" type="text" value="Sunayra">-->
<!--                                            </div>-->
<!--                                        </div>-->
                                        <div class="email-area mb--15">
                                            <label for="username" class="form-label">Change Your Username</label>
                                            <input id="username" type="text" v-model="currentUser.username">
                                        </div>
                                        <div class="email-area">
                                            <label for="Email" class="form-label">Edit Your Email</label>
                                            <input id="Email" type="email" v-model="currentUser.email">
                                        </div>
                                    </div>
                                    <div class="edit-bio-area mt--30">
                                        <label for="description" class="form-label">Edit Your Brief Introduction</label>
                                        <textarea id="description" placeholder="e.g. Hello everyone, I am ... who is applying for the oversea university programs..." v-model="currentUser.bio"></textarea>
                                    </div>

<!--                                    <div class="input-two-wrapepr-prifile">-->
<!--                                        <div class="role-area mt&#45;&#45;15">-->
<!--                                            <label for="gpa" class="form-label mb&#45;&#45;10">Your Graduate GPA</label>-->
<!--                                            <input id="gpa" type="number" value="3.81">-->
<!--                                        </div>-->
<!--                                        <select class="profile-edit-select">-->
<!--                                            <option selected>Select Your English Proficiency Test</option>-->
<!--                                            <option value="1">IELTS</option>-->
<!--                                            <option value="2">TOEFL</option>-->
<!--                                        </select>-->
<!--                                    </div>-->

<!--                                    <div class="input-two-wrapper mt&#45;&#45;15">-->
<!--                                        <div class="half-wid currency">-->
<!--                                            <select class="profile-edit-select">-->
<!--                                                <option selected>Currency</option>-->
<!--                                                <option value="1">($)USD</option>-->
<!--                                                <option value="2">wETH</option>-->
<!--                                                <option value="3">BIT Coin</option>-->
<!--                                            </select>-->
<!--                                        </div>-->
<!--                                        <div class="half-wid phone-number">-->
<!--                                            <label for="PhoneNumber" class="form-label">Phone Number</label>-->
<!--                                            <input id="PhoneNumber" type="text" value="+880100000000">-->
<!--                                        </div>-->
<!--                                    </div>-->
<!--                                    <div class="input-two-wrapper mt&#45;&#45;15">-->
<!--                                        <div class="half-wid currency">-->
<!--                                            <select class="profile-edit-select">-->
<!--                                                <option selected>Location</option>-->
<!--                                                <option value="1">United State</option>-->
<!--                                                <option value="2">Katar</option>-->
<!--                                                <option value="3">Canada</option>-->
<!--                                            </select>-->
<!--                                        </div>-->
<!--                                        <div class="half-wid phone-number">-->
<!--                                            <label for="address" class="form-label">Address</label>-->
<!--                                            <input id="address" type="text" value="USA Cidni">-->
<!--                                        </div>-->
<!--                                    </div>-->
                                    <div class="button-area save-btn-edit">
<!--                                        <a href="#" class="btn btn-primary-alta mr&#45;&#45;15" @click="alert('Cancel Edit Profile?')">Cancel</a>-->
                                        <a href="#" class="btn btn-primary" @click="editPersonalInfo()">Save</a>
                                    </div>
                                </div>
                            </div>

                            <!-- Application Background Panel -->
                            <div class="tab-pane fade" id="nav-application-background" role="tabpanel" aria-labelledby="nav-background-tab">
                                <div class="nuron-information">

                                    <h5 class="title">Application Target</h5>
                                    <hr />

                                    <div class="input-two-wrapper">
                                        <div class="half-wid">
                                            <label for="apply-round" class="form-label mb--10">Application Round</label>
                                            <select id="apply-round" class="profile-edit-select mt--0">
                                                <option value="1">2023 - Fall</option>
                                                <option value="1">2023 - Spring</option>
                                                <option value="1">2023 - Summer</option>
                                                <option value="1">2024 - Fall</option>
                                                <option value="1">2024 - Spring</option>
                                                <option value="1">2024 - Summer</option>
                                                <option value="1">2025 - Fall</option>
                                                <option value="1">2025 - Spring</option>
                                                <option value="1">2025 - Summer</option>
                                            </select>
                                        </div>
                                        <div class="half-wid ml--15">
                                            <label for="apply-degree" class="form-label mb--10">Target Degree</label>
                                            <select id="apply-degree" class="profile-edit-select mt--0">
                                                <option value="1">PhD</option>
                                                <option value="1">MS</option>
                                                <option value="1">MEng</option>
                                                <option value="1">MA</option>
                                                <option value="1">MPhil</option>
                                                <option value="1">MPH</option>
                                                <option value="1">MBA</option>
                                                <option value="1">LLM</option>
                                                <option value="1">MEd</option>
                                                <option value="1">JD</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="input-two-wrapper mt--15">
                                        <div class="half-wid">
                                            <label for="apply-major" class="form-label mb--10">Major to Apply</label>
                                            <select id="apply-major" class="profile-edit-select mt--0">
                                                <option value="1">CS</option>
                                                <option value="1">MIS</option>
                                                <option value="1">EE</option>
                                                <option value="1">BME</option>
                                                <option value="1">ME</option>
                                                <option value="1">IEOR</option>
                                                <option value="1">Stat / Biostat</option>
                                                <option value="1">BioInfo</option>
                                                <option value="1">MFE/Fin/FinMath</option>
                                                <option value="1">Econ/Biz</option>
                                                <option value="1">Math/AppliedMath</option>
                                                <option value="1">Physics</option>
                                                <option value="1">Accounting</option>
                                                <option value="1">Chemical</option>
                                                <option value="1">Material</option>
                                                <option value="1">Education</option>
                                                <option value="1">Computer Engineering</option>
                                                <option value="1">HCI</option>
                                                <option value="1">Law</option>
                                                <option value="1">Psychology</option>
                                                <option value="1">other</option>
                                            </select>
                                        </div>
                                        <div class="half-wid ml--15">
                                            <label for="ad-type" class="form-label mb--10">Target Offer Type</label>
                                            <select id="ad-type" class="profile-edit-select mt--0">
                                                <option value="1">AD - With Fellowship</option>
                                                <option value="1">AD - Without Fellowship</option>
                                            </select>
                                        </div>
                                    </div>

                                    <h5 class="title mt--50">Undergraduate Background</h5>
                                    <hr />

                                    <div class="input-two-wrapper">
                                        <div class="half-wid">
                                            <label for="school-classify" class="form-label mb--10">Undergraduate School Classification</label>
                                            <select id="school-classify" class="profile-edit-select mt--0">
                                                <option value="1">Oversea Undergraduate</option>
                                                <option value="2">Tsinghua University / Peking University</option>
                                                <option value="3">Top 15</option>
                                                <option value="3">Top 30</option>
                                                <option value="3">Other 985 / 211</option>
                                                <option value="3">Not 985 / 211</option>
                                            </select>
                                        </div>
                                        <div class="half-wid phone-number">
                                            <label for="school-name" class="form-label mb--10">Your Undergraduate School</label>
                                            <input id="school-name" type="text" >
                                        </div>
                                    </div>

                                    <div class="input-two-wrapepr-prifile">
                                        <div class="input-two-wrapepr-prifile w-100">
                                            <div class="role-area mt--15">
                                                <label for="gpa" class="form-label mb--10">GPA</label>
                                                <input id="gpa" type="number" v-model="currentUser.profile.gpa">
                                            </div>
                                            <div class="role-area mt--15">
                                                <label for="rank" class="form-label mb--10">Rank</label>
                                                <input id="rank" type="number">
                                            </div>
                                        </div>
                                        <div class="role-area mt--15 w-100 ml--25">
                                            <label for="major" class="form-label mb--10">Undergraduate Major</label>
                                            <select id="major" class="profile-edit-select w-100 mt--0 m-lg-0">
                                                <option value="1">CS</option>
                                                <option value="1">MIS</option>
                                                <option value="1">EE</option>
                                                <option value="1">BME</option>
                                                <option value="1">ME</option>
                                                <option value="1">IEOR</option>
                                                <option value="1">Stat / Biostat</option>
                                                <option value="1">BioInfo</option>
                                                <option value="1">MFE/Fin/FinMath</option>
                                                <option value="1">Econ/Biz</option>
                                                <option value="1">Math/AppliedMath</option>
                                                <option value="1">Physics</option>
                                                <option value="1">Accounting</option>
                                                <option value="1">Chemical</option>
                                                <option value="1">Material</option>
                                                <option value="1">Education</option>
                                                <option value="1">Computer Engineering</option>
                                                <option value="1">HCI</option>
                                                <option value="1">Law</option>
                                                <option value="1">Psychology</option>
                                                <option value="1">other</option>
                                            </select>
                                        </div>
                                    </div>

                                    <h5 class="title mt--50">English Proficiency Tests</h5>
                                    <hr />

                                    <div class="input-two-wrapper">
                                        <div class="half-wid">
                                            <label for="score-type" class="form-label mb--10">English Proficiency Test Type</label>
                                            <select id="score-type" class="profile-edit-select mt--0">
                                                <option value="1">IELTS</option>
                                                <option value="1">TOEFL</option>
                                            </select>
                                        </div>
                                        <div class="half-wid ml--15">
                                            <label for="score-total" class="form-label mb--10">Total Score</label>
                                            <input id="score-total" type="number">
                                        </div>
                                    </div>

                                    <div class="input-two-wrapepr-prifile">
                                        <div class="input-two-wrapepr-prifile w-100">
                                            <div class="role-area mt--15">
                                                <label for="score-listening" class="form-label mb--10">Listening</label>
                                                <input id="score-listening" type="number">
                                            </div>
                                            <div class="role-area mt--15">
                                                <label for="score-speaking" class="form-label mb--10">Speaking</label>
                                                <input id="score-speaking" type="number">
                                            </div>
                                        </div>
                                        <div class="input-two-wrapepr-prifile w-100">
                                            <div class="role-area mt--15">
                                                <label for="score-reading" class="form-label mb--10">Reading</label>
                                                <input id="score-reading" type="number">
                                            </div>
                                            <div class="role-area mt--15">
                                                <label for="score-writing" class="form-label mb--10">Writing</label>
                                                <input id="score-writing" type="number">
                                            </div>
                                        </div>
                                    </div>

                                    <h5 class="title mt--50">Graduate Record Examination (GRE)</h5>
                                    <hr/>

                                    <div class="input-two-wrapepr-prifile">
                                        <div class="input-two-wrapepr-prifile w-100">
                                            <div class="role-area">
                                                <label for="gre-total" class="form-label mb--10">Total Score</label>
                                                <input id="gre-total" type="number">
                                            </div>
                                            <div class="role-area">
                                                <label for="gre-aw" class="form-label mb--10">Analytical Writing</label>
                                                <input id="gre-aw" type="number">
                                            </div>
                                        </div>
                                        <div class="input-two-wrapepr-prifile w-100">
                                            <div class="role-area">
                                                <label for="gre-v" class="form-label mb--10">Verbal</label>
                                                <input id="gre-v" type="number">
                                            </div>
                                            <div class="role-area">
                                                <label for="gre-q" class="form-label mb--10">Quantitative</label>
                                                <input id="gre-q" type="number">
                                            </div>
                                        </div>
                                    </div>

<!--                                    <div class="input-two-wrapper mt&#45;&#45;15">-->
<!--                                        <div class="half-wid">-->
<!--                                            <select class="profile-edit-select">-->
<!--                                                <option selected>Currency</option>-->
<!--                                                <option value="1">($)USD</option>-->
<!--                                                <option value="2">wETH</option>-->
<!--                                                <option value="3">BIT Coin</option>-->
<!--                                            </select>-->
<!--                                        </div>-->
<!--                                        <div class="half-wid phone-number">-->
<!--                                            <label for="PhoneNumber" class="form-label">Phone Number</label>-->
<!--                                            <input id="PhoneNumber" type="text" value="+880100000000">-->
<!--                                        </div>-->
<!--                                    </div>-->
<!--                                    <div class="input-two-wrapper mt&#45;&#45;15">-->
<!--                                        <div class="half-wid currency">-->
<!--                                            <select class="profile-edit-select">-->
<!--                                                <option selected>Location</option>-->
<!--                                                <option value="1">United State</option>-->
<!--                                                <option value="2">Katar</option>-->
<!--                                                <option value="3">Canada</option>-->
<!--                                            </select>-->
<!--                                        </div>-->
<!--                                        <div class="half-wid phone-number">-->
<!--                                            <label for="address" class="form-label">Address</label>-->
<!--                                            <input id="address" type="text" value="USA Cidni">-->
<!--                                        </div>-->
<!--                                    </div>-->


                                    <div class="button-area save-btn-edit">
<!--                                        <a href="#" class="btn btn-primary-alta mr&#45;&#45;15" @click="alert('Cancel Edit Profile?')">Cancel</a>-->
                                        <a href="#" class="btn btn-primary" @click="editApplyBackground()">Save</a>
                                    </div>
                                </div>
                            </div>

                            <!-- Password Management Panel -->
                            <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                                <div class="nuron-information">
                                    <div class="condition">
                                        <h5 class="title">Change Your Password</h5>
                                        <p class="condition">
                                            Your password is a critical part of your account security and privacy. We recommend
                                            you to change your password regularly through this page to ensure the security
                                            of your account. Keep in mind that a poorly chosen password might put your privacy
                                            at risks.
                                        </p>
                                        <hr />
                                        <div class="email-area">
                                            <label for="Email2" class="form-label">Enter Email</label>
                                            <input id="Email2" type="email" v-model="changePasswordParams.email">
                                        </div>
                                    </div>
                                    <div class="input-two-wrapper mt--15">
                                        <div class="old-password half-wid">
                                            <label for="oldPass" class="form-label">Enter Old Password</label>
                                            <input id="oldPass" type="password" v-model="changePasswordParams.oldPassword">
                                        </div>
                                        <div class="new-password half-wid">
                                            <label for="NewPass" class="form-label">Create New Password</label>
                                            <input id="NewPass" type="password" v-model="changePasswordParams.newPassword">
                                        </div>
                                    </div>
                                    <div class="email-area mt--15">
                                        <label for="rePass" class="form-label">Confirm Your New Password</label>
                                        <input id="rePass" type="password" v-model="changePasswordParams.reNewPassword">
                                    </div>
                                    <a href="#" class="btn btn-primary save-btn-edit" @click="changePassword()">Save</a>
                                </div>
                            </div>

                            <!-- Notification Setting Panel -->
                            <div class="tab-pane fade " id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                                <div class="nuron-information">
                                    <h5 class="title">Make Sure Your Notification setting </h5>
                                    <p class="notice-disc">
                                        Notification Center is where you can find app notifications and Quick Settings—which
                                        give you quick access to commonly used settings and apps. You can change your
                                        notification settings at any time from the Settings app. Select Start , then select
                                        Settings
                                    </p>
                                    <hr/>

                                    <div class="notice-parent-wrapper d-flex">
                                        <div class="notice-child-wrapper">
                                            <!-- single notice wrapper -->
                                            <div class="single-notice-setting">
                                                <div class="input">
                                                    <input type="checkbox" id="themeSwitch" name="theme-switch" class="theme-switch__input" />
                                                    <label for="themeSwitch" class="theme-switch__label">
                                                        <span></span>
                                                    </label>
                                                </div>
                                                <div class="content-text">
                                                    <p>Order Confirmation Notice</p>
                                                </div>
                                            </div>
                                            <!-- single notice wrapper End -->

                                            <!-- single notice wrapper -->
                                            <div class="single-notice-setting mt--15">
                                                <div class="input">
                                                    <input type="checkbox" id="themeSwitchs" name="theme-switch" class="theme-switch__input" />
                                                    <label for="themeSwitchs" class="theme-switch__label">
                                                        <span></span>
                                                    </label>
                                                </div>
                                                <div class="content-text">
                                                    <p>New Items Notification</p>
                                                </div>
                                            </div>
                                            <!-- single notice wrapper End -->

                                            <!-- single notice wrapper -->
                                            <div class="single-notice-setting mt--15">
                                                <div class="input">
                                                    <input type="checkbox" id="OrderNotice" name="theme-switch" class="theme-switch__input" />
                                                    <label for="OrderNotice" class="theme-switch__label">
                                                        <span></span>
                                                    </label>
                                                </div>
                                                <div class="content-text">
                                                    <p>New Bid Notification</p>
                                                </div>
                                            </div>
                                            <!-- single notice wrapper End -->

                                            <!-- single notice wrapper -->
                                            <div class="single-notice-setting mt--15">
                                                <div class="input">
                                                    <input type="checkbox" id="newPAy" name="theme-switch" class="theme-switch__input" />
                                                    <label for="newPAy" class="theme-switch__label">
                                                        <span></span>
                                                    </label>
                                                </div>
                                                <div class="content-text">
                                                    <p>Payment Card Notification</p>
                                                </div>
                                            </div>
                                            <!-- single notice wrapper End -->

                                            <!-- single notice wrapper -->
                                            <div class="single-notice-setting mt--15">
                                                <div class="input">
                                                    <input type="checkbox" id="EndBid" name="theme-switch" class="theme-switch__input" />
                                                    <label for="EndBid" class="theme-switch__label">
                                                        <span></span>
                                                    </label>
                                                </div>
                                                <div class="content-text">
                                                    <p>Ending Bid Notification Before 5 min</p>
                                                </div>
                                            </div>
                                            <!-- single notice wrapper End -->

                                            <!-- single notice wrapper -->
                                            <div class="single-notice-setting mt--15">
                                                <div class="input">
                                                    <input type="checkbox" id="Approve" name="theme-switch" class="theme-switch__input" />
                                                    <label for="Approve" class="theme-switch__label">
                                                        <span></span>
                                                    </label>
                                                </div>
                                                <div class="content-text">
                                                    <p>Notification for approving product</p>
                                                </div>
                                            </div>
                                            <!-- single notice wrapper End -->
                                        </div>
                                        <div class="notice-child-wrapper"></div>
                                    </div>
                                    <button class="btn btn-primary save-btn-edit" @click="alert('Successfully saved Your Notification setting')">
                                        Save
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </layout>
</template>

<script>
    import Layout from "@/components/layouts/Layout";
    import Breadcrumb from "@/components/breadcrumb/Breadcrumb";

    import cookie from "js-cookie";
    import profileApi from "@/api/profile";
    import router from "@/router/index";
    import userLoader from "@/utils/userloader";

    export default {
        name: 'EditProfilePage',
        components: {Breadcrumb, Layout},
        data(){
            return {
                currentUser: {
                    avatar: "",
                    email: "",
                    username: "",
                    bio: "",
                    profile: {
                        gpa: ""
                    }
                },

                changePasswordParams: {
                    email: "",
                    oldPassword: "",
                    newPassword: "",
                    reNewPassword: ""
                }
            }
        },

        created() {
            // load the current user info as this page is created
            // user would be redirected to the login page if not logged in

            this.getCurrentUser();
            // this.currentUser = userLoader.getCurrentUser();
        },

        methods: {
            // after selecting an image when changing avatar, this function would be called
            previewImage(e, id) {
                if (e.target.files && e.target.files.length > 0) {
                    // preview
                    const file = e.target.files[0];
                    document.querySelector(`#${id}`).setAttribute('src', URL.createObjectURL(file));
                    // upload avatar
                    this.uploadAvatar(file);
                }
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
                    window.alert("You should login first!");
                    router.push({path: '/login'});
                }
            },

            uploadAvatar(file){
                // encapsulate the avatar file into a form obj
                let formData = new FormData();
                formData.append("file", file);

                // call the api method
                profileApi.uploadAvatar(formData)
                    .then(response => {
                        // notify user
                        window.alert("upload successfully!");

                        // update the current_user and cookie
                        this.currentUser = response.data.user;
                        cookie.set("current_user", JSON.stringify(this.currentUser), { domain: 'localhost' });
                    })
                    .catch(error => {
                        // notify user
                        if(error.response.data.message){
                            window.alert(error.response.data.message);
                        }
                    })

            },

            changePassword(){
                // call the api method
                profileApi.changePassword(this.changePasswordParams)
                    .then(response => {
                        // notify user
                        window.alert("Password changed successfully!");

                        // update the current_user and cookie
                        this.currentUser = response.data.user;
                        cookie.set("current_user", JSON.stringify(this.currentUser), { domain: 'localhost' });

                    })
                    .catch(error => {
                        // notify user
                        if(error.response.data.message){
                            window.alert(error.response.data.message);
                        }
                    })
            },

            editPersonalInfo(){
                // trim the spaces in the user inputs
                this.currentUser.email = this.currentUser.email.trim();
                this.currentUser.username = this.currentUser.username.trim();
                this.currentUser.bio = this.currentUser.bio.trim();

                // call the api method
                profileApi.editPersonalInfo(this.currentUser)
                    .then(response => {
                        // notify user
                        window.alert("Personal info changed successfully!");

                        // update the current_user and cookie
                        this.currentUser = response.data.user;
                        cookie.set("current_user", JSON.stringify(this.currentUser), { domain: 'localhost' });

                    })
                    .catch(error => {
                        // notify user
                        if(error.response.data.message){
                            window.alert(error.response.data.message);
                        }
                    })
            },

            editApplyBackground(){
                // call the api method
                profileApi.editApplyBackground(this.currentUser.profile)
                    .then(response => {
                        // notify user
                        window.alert("Application background updated successfully!");

                        // update the current_user and cookie
                        this.currentUser = response.data.user;
                        cookie.set("current_user", JSON.stringify(this.currentUser), { domain: 'localhost' });

                    })
                    .catch(error => {
                        // notify user
                        if(error.response.data.message){
                            window.alert(error.response.data.message);
                        }
                    })
            }

        }
    }
</script>