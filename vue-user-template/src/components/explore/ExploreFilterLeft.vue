<template>
    <div id="explore-id"
         class="explore-area rn-section-gapTop">
        <div class="container">
            <div class="row mb--40">
                <div class="col-12">
                    <h3 class="title">Find Your Non Replaceable Token</h3>
                </div>
            </div>
            <div class="row g-5">
                <div class="col-lg-3 order-2 order-lg-1">
                    <div class="nu-course-sidebar">
                        <!-- Start Widget Wrapper  -->
                        <div class="nuron-expo-filter-widget widget-shortby">
                            <div class="inner">
                                <h5 class="widget-title">Sort By</h5>
                                <div class="content">
                                    <div class="nuron-form-check">
                                        <input
                                            type="radio"
                                            id="short-check1"
                                            value="newest"
                                            name="sort"
                                            v-model="checkedSortBy"
                                            @change="sortByFilter()"
                                        />
                                        <label for="short-check1">
                                            Newest
                                        </label>
                                    </div>
                                    <div class="nuron-form-check">
                                        <input
                                            type="radio"
                                            id="short-check2"
                                            value="oldest"
                                            name="sort"
                                            v-model="checkedSortBy"
                                            @change="sortByFilter()"
                                        />
                                        <label for="short-check2">
                                            Oldest
                                        </label>
                                    </div>
                                    <div class="nuron-form-check">
                                        <input
                                            type="radio"
                                            id="short-check3"
                                            value="most-liked"
                                            name="sort"
                                            v-model="checkedSortBy"
                                            @change="sortByFilter()"
                                        />
                                        <label for="short-check3">
                                            Most Liked
                                        </label>
                                    </div>
                                    <div class="nuron-form-check">
                                        <input
                                            type="radio"
                                            id="short-check4"
                                            value="least-liked"
                                            name="sort"
                                            v-model="checkedSortBy"
                                            @change="sortByFilter()"
                                        />
                                        <label for="short-check4">
                                            Least Liked
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End Widget Wrapper  -->

                        <!-- Start Widget Wrapper  -->
                        <div class="nuron-expo-filter-widget widget-category mt--30">
                            <div class="inner">
                                <h5 class="widget-title">Categories</h5>
                                <div class="content">
                                    <template v-for="(value, propertyName, catIndex) in productCategories">
                                        <div class="nuron-form-check">
                                            <input
                                                type="checkbox"
                                                :id="`cat-check${catIndex}`"
                                                :value="propertyName"
                                                v-model="checkedCategories"
                                                @change="filterCategory()"
                                            />
                                            <label :for="`cat-check${catIndex}`" class="text-capitalize">
                                                {{ propertyName }} <span>({{ value }})</span>
                                            </label>
                                        </div>
                                    </template>
                                </div>
                            </div>
                        </div>
                        <!-- End Widget Wrapper  -->

                        <!-- Start Widget Wrapper  -->
                        <div class="nuron-expo-filter-widget widget-shortby mt--30">
                            <div class="inner">
                                <h5 class="widget-title">Level</h5>
                                <div class="content">
                                    <div class="nuron-form-check">
                                        <input
                                            type="checkbox"
                                            id="level-check0"
                                        />
                                        <label for="level-check0">
                                            All Skill
                                        </label>
                                    </div>
                                    <template v-for="(level, levelIndex) in productLevels">
                                        <div class="nuron-form-check">
                                            <input
                                                type="checkbox"
                                                :id="`level-check${levelIndex + 1}`"
                                                :value="level"
                                                v-model="checkedLevels"
                                                @change="filterLevel()"
                                            />
                                            <label :for="`level-check${levelIndex + 1}`" class="text-capitalize">
                                                {{ level }}
                                            </label>
                                        </div>
                                    </template>
                                </div>
                            </div>
                        </div>
                        <!-- End Widget Wrapper  -->

                        <!-- Start Widget Wrapper  -->
                        <div class="nuron-expo-filter-widget widget-shortby mt--30">
                            <div class="inner">
                                <h5 class="widget-title">Price</h5>
                                <div class="content">
                                    <div class="nuron-form-check">
                                        <input
                                            type="radio"
                                            id="price-check2"
                                            value="low-to-high"
                                            name="price"
                                            v-model="checkedByPrice"
                                            @change="priceFilter()"
                                        />
                                        <label for="price-check2">
                                            Price: Low to High
                                        </label>
                                    </div>
                                    <div class="nuron-form-check">
                                        <input
                                            type="radio"
                                            id="price-check3"
                                            value="high-to-low"
                                            name="price"
                                            v-model="checkedByPrice"
                                            @change="priceFilter()"
                                        />
                                        <label for="price-check3">
                                            Price: High to Low
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End Widget Wrapper  -->

                        <!-- Start Widget Wrapper  -->
                        <div class="nuron-expo-filter-widget widget-shortby mt--30">
                            <div class="inner">
                                <h5 class="widget-title">Language</h5>
                                <div class="content">
                                    <div class="nuron-form-check">
                                        <input
                                            type="checkbox"
                                            id="lang-check0"
                                        />
                                        <label for="lang-check0">
                                            All Language
                                        </label>
                                    </div>
                                    <template v-for="(language, langIndex) in productLanguages">
                                        <div class="nuron-form-check">
                                            <input
                                                type="checkbox"
                                                :id="`lang-check${langIndex + 1}`"
                                                :value="language"
                                                v-model="checkedLanguages"
                                                @change="filterLanguages()"
                                            />
                                            <label :for="`lang-check${langIndex + 1}`" class="text-capitalize">
                                                {{ language }}
                                            </label>
                                        </div>
                                    </template>
                                </div>
                            </div>
                        </div>
                        <!-- End Widget Wrapper  -->

                        <!-- Start Widget Wrapper  -->
                        <div class="nuron-expo-filter-widget widget-shortby mt--30">
                            <div class="inner">
                                <h5 class="widget-title">Short By Rating</h5>
                                <div class="content">
                                    <div class="nuron-form-check">
                                        <input
                                            type="checkbox"
                                            id="rating-check1"
                                            value="5"
                                            v-model="checkedRatings"
                                            @change="filterRatings()"
                                        />
                                        <label for="rating-check1">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                        </label>
                                    </div>
                                    <div class="nuron-form-check">
                                        <input
                                            type="checkbox"
                                            id="rating-check2"
                                            value="4"
                                            v-model="checkedRatings"
                                            @change="filterRatings()"
                                        />
                                        <label for="rating-check2">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill off" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                        </label>
                                    </div>
                                    <div class="nuron-form-check">
                                        <input
                                            type="checkbox"
                                            id="rating-check3"
                                            value="3"
                                            v-model="checkedRatings"
                                            @change="filterRatings()"
                                        />
                                        <label for="rating-check3">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill off" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill off" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                        </label>
                                    </div>
                                    <div class="nuron-form-check">
                                        <input
                                            type="checkbox"
                                            id="rating-check4"
                                            value="2"
                                            v-model="checkedRatings"
                                            @change="filterRatings()"
                                        />
                                        <label for="rating-check4">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill off" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill off" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill off" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                        </label>
                                    </div>
                                    <div class="nuron-form-check">
                                        <input
                                            type="checkbox"
                                            id="rating-check5"
                                            value="1"
                                            v-model="checkedRatings"
                                            @change="filterRatings()"
                                        />
                                        <label for="rating-check5">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill off" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill off" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill off" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-star-fill off" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                            </svg>
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End Widget Wrapper  -->

                        <!-- Start Widget Wrapper  -->
                        <div class="nuron-expo-filter-widget widget-shortby mt--30">
                            <div class="inner">
                                <h5 class="widget-title">Filter By Price</h5>
                                <div class="price_filter s-filter clear">
                                    <form action="#" method="GET">
                                        <range-slider
                                            :show-filter-button="false"
                                            @onChangeRange="onChangeRange"
                                            @filterPrice="filterPrice"
                                        />
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- End Widget Wrapper  -->
                    </div>
                </div>
                <div class="col-lg-9 order-1 order-lg-2">
                    <div class="row g-5">
                        <template v-for="(product, index) in filteredRows.slice(pageStart, pageStart + countOfPage)"
                                  :key="`product-item-${index}`">
                            <div class="col-lg-4 col-md-6 col-sm-12">
                                <product-card
                                    :product-date="product"
                                    product-style-class="no-overlay with-placeBid"
                                    :show-countdown="false"
                                    :show-place-bid="true"
                                />
                            </div>
                        </template>
                        <h3 v-if="!filteredProducts.length" class="text-center">No Match Found</h3>
                        <blog-pagination
                            class="mt-0"
                            pagination-class="mt--40"
                            :posts="filteredProducts"
                            :scroll-control="true"
                            @paginatedData="paginatedData"
                            @scrollControl="scrollIntoTop"
                            :count-of-page="12"
                        />
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import RangeSlider from '@/components/range/RangeSlider'
    import NiceSelect from '@/components/select/NiceSelect'
    import ProductCard from '@/components/product/ProductCard'
    import ProductCheckboxFilterMixin from '@/mixins/ProductCheckboxFilterMixin'
    import BlogPagination from '@/components/pagination/BlogPagination'

    export default {
        name: 'ExploreFilterLeft',
        components: {BlogPagination, RangeSlider, NiceSelect, ProductCard},
        mixins: [ProductCheckboxFilterMixin]
    }
</script>
