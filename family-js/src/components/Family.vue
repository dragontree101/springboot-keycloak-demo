<template xmlns:v-on="http://www.w3.org/1999/xhtml">
    <div class="family">
        <h1>{{ message }}</h1>
        <button v-on:click="showAllInfo">展示家庭所有成员信息</button>
        <table class="bordered" style="table-layout:fixed;" id="tables">
            <thead>
            <th v-for="item in headers">{{item}}</th>
            </thead>
            <tbody>
            <!-- 每次for循环，都会创建一个tr标签。item是遍历的元素。 -->
            <tr v-for="item in familyList">
                <td>{{ item.name }}</td>
                <td>{{ item.age }}</td>
                <td>{{ item.email }}</td>
                <td>{{ item.phone }}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    var headers = [
        '姓名',
        '年龄',
        '邮箱',
        '电话'
    ];

    export default {
        name: 'tables',
        data () {
            return {
                message: 'My Family List',
                headers: headers,
                familyList: []
            }
        },
        methods: {
            showAllInfo: function () {
                this.$http.get('http://127.0.0.1:8088/family/all').then(response => {
                    // get body data
                    this.familyList = response.body;
                }, response => {
                    // error callback
                    console.error("query server error")
                });
            }
        }
    }
</script>

<style>
    table,
    td,
    th {
        border-collapse: collapse;
        border-spacing: 0
    }

    table {
        width: 100%;
    }

    td,
    th {
        border: 1px solid #bcbcbc;
        padding: 5px 10px;
    }

    th {
        padding: 10px;
        font-weight: 400;
        color: #fff;
        background: #0090d3;
        cursor: pointer;
    }

    tr:nth-of-type(odd) {
        background: #fff
    }

    tr:nth-of-type(even) {
        background: #eee
    }
</style>

