<template>
    <div>
        {{ name }}

        <input type="text" value="" :model="val">
    </div>
</template>

<script>
    export default {
        name: "personal",
        data(){
            return {
                name:"personal",
                val:12
            }
        }
    }
</script>

<style scoped>

</style>