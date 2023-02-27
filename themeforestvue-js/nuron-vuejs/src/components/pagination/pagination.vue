<template>
    <nav class="pagination-wrapper" aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><router-link class="page-link" to="#">Previous</router-link></li>
            <li class="page-item"><router-link class="page-link active" to="#">1</router-link></li>
            <li class="page-item"><router-link class="page-link" to="#">2</router-link></li>
            <li class="page-item"><router-link class="page-link" to="#">3</router-link></li>
            <li class="page-item"><router-link class="page-link" to="#">Next</router-link></li>
        </ul>
    </nav>
</template>

<script>
    export default {
        name: 'pagination'
    }
</script>