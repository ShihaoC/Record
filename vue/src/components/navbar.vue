<template>
  <div class="navbar">
    <ul class="navbar-nav">
      <li class="logo">
        <a href="#" class="nav-link">
          <span class="link-text" id="link-text1">员工管理系统</span>
          <svg id="test" t="1668663721482" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3489" width="200" height="200"><path d="M416.096 167.776H223.904A64 64 0 0 0 160 231.68v192.192a64 64 0 0 0 63.904 63.904h192.192A64 64 0 0 0 480 423.872V231.68a64 64 0 0 0-63.904-63.904M885.088 282.56l-135.904-135.872a64 64 0 0 0-90.368 0L640 165.504 522.912 282.56a63.456 63.456 0 0 0-18.656 45.056 63.456 63.456 0 0 0 18.656 45.312l18.816 18.816L640 490.08l18.816 18.816a63.904 63.904 0 0 0 90.368-0.032l117.088-117.12 18.816-18.784a63.936 63.936 0 0 0 0-90.368M416.096 551.776H223.904A64 64 0 0 0 160 615.68v192.192a64 64 0 0 0 63.904 63.904h192.192A64 64 0 0 0 480 807.872V615.68a64 64 0 0 0-63.904-63.904M800.096 551.776h-192.192A64 64 0 0 0 544 615.68v192.192a64 64 0 0 0 63.904 63.904h192.192A64 64 0 0 0 864 807.872V615.68a64 64 0 0 0-63.904-63.904" p-id="3490" fill="#e6e6e6"></path></svg>
        </a>
      </li>
      <li class="nav-item">
        <a href="javascript:void(0);" @click="EmployeeManage()" class="nav-link">
          <svg aria-hidden="true" focusable="false" data-prefix="far" data-icon="user" class="svg-inline--fa fa-user fa-w-14 fa-sm"
               role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
            <path fill="currentColor"
                  d="M313.6 304c-28.7 0-42.5 16-89.6 16-47.1 0-60.8-16-89.6-16C60.2 304 0 364.2 0 438.4V464c0 26.5 21.5 48 48 48h352c26.5 0 48-21.5 48-48v-25.6c0-74.2-60.2-134.4-134.4-134.4zM400 464H48v-25.6c0-47.6 38.8-86.4 86.4-86.4 14.6 0 38.3 16 89.6 16 51.7 0 74.9-16 89.6-16 47.6 0 86.4 38.8 86.4 86.4V464zM224 288c79.5 0 144-64.5 144-144S303.5 0 224 0 80 64.5 80 144s64.5 144 144 144zm0-240c52.9 0 96 43.1 96 96s-43.1 96-96 96-96-43.1-96-96 43.1-96 96-96z">
            </path>
          </svg>
          <span id="link-text" class="link-text" >员工管理</span>
        </a>
      </li>
      <li class="nav-item">
        <a href="javascript:void(0);" @click="manage()" class="nav-link">
          <svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="chart-bar"
               class="svg-inline--fa fa-chart-bar fa-w-16" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
            <path fill="currentColor"
                  d="M332.8 320h38.4c6.4 0 12.8-6.4 12.8-12.8V172.8c0-6.4-6.4-12.8-12.8-12.8h-38.4c-6.4 0-12.8 6.4-12.8 12.8v134.4c0 6.4 6.4 12.8 12.8 12.8zm96 0h38.4c6.4 0 12.8-6.4 12.8-12.8V76.8c0-6.4-6.4-12.8-12.8-12.8h-38.4c-6.4 0-12.8 6.4-12.8 12.8v230.4c0 6.4 6.4 12.8 12.8 12.8zm-288 0h38.4c6.4 0 12.8-6.4 12.8-12.8v-70.4c0-6.4-6.4-12.8-12.8-12.8h-38.4c-6.4 0-12.8 6.4-12.8 12.8v70.4c0 6.4 6.4 12.8 12.8 12.8zm96 0h38.4c6.4 0 12.8-6.4 12.8-12.8V108.8c0-6.4-6.4-12.8-12.8-12.8h-38.4c-6.4 0-12.8 6.4-12.8 12.8v198.4c0 6.4 6.4 12.8 12.8 12.8zM496 384H64V80c0-8.84-7.16-16-16-16H16C7.16 64 0 71.16 0 80v336c0 17.67 14.33 32 32 32h464c8.84 0 16-7.16 16-16v-32c0-8.84-7.16-16-16-16z">
            </path>
          </svg>
          <span class="link-text" @click="console.log(123)">报表管理</span>
        </a>
      </li>
      <li class="nav-item">
        <a href="#" class="nav-link">
          <svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="moon" class="svg-inline--fa fa-moon fa-w-16"
               role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
            <path fill="currentColor"
                  d="M283.211 512c78.962 0 151.079-35.925 198.857-94.792 7.068-8.708-.639-21.43-11.562-19.35-124.203 23.654-238.262-71.576-238.262-196.954 0-72.222 38.662-138.635 101.498-174.394 9.686-5.512 7.25-20.197-3.756-22.23A258.156 258.156 0 0 0 283.211 0c-141.309 0-256 114.511-256 256 0 141.309 114.511 256 256 256z">
            </path>
          </svg>
          <span class="link-text">更换</span>
        </a>
      </li>
    </ul>
  </div>
</template>
<script>
  export default {
    name: 'navbar',
    methods:{
      manage(){
        this.$router.push({path:'/manage'})
      },
      EmployeeManage(){
        this.$router.push({path:'/EmployeeManage'})

      }
    }
  }

</script>
<style>
  @import "../css/navbar.css";
</style>