<template>
  <div class="container">
    <div class="course-container">
      <div class="card">
        <div class="card-header">
          <div class="row">
            <div class="col col-xs-6">
              <h3 class="panel-title">Cursos</h3>
            </div>
          </div>
        </div>

        <div class="card-body">
             <table class="table">
                        <thead>
                            <tr>
                                <th>ID Curso </th>
                                <th>Instrutor</th>
                                <th>Curso</th>
                               
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="course in courses" v-bind:key="course.id">
                                <td>{{course.id}}</td>
                                 <td>{{course.username}}</td>
                                <td>{{course.description}}</td>
                                <td><button class="btn btn-success" v-on:click="updateCourse(course.id)">Edit</button></td>
                                <td><button class="btn btn-warning" v-on:click="deleteCourse(course.id)">Delete</button></td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="row">
                        <button class="btn btn-success" v-on:click="addCourse()">Adicionar Curso</button>
                    </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import UserService from "../services/user.service";
import CourseDataService from "../services/CourseDataService";
import { User } from "../models/user";
import { Transaction } from "../models/transaction";
export default {
    name: "Courses",
    data() {
        return {
            courses: [],
            message: "",
            INSTRUCTOR: "in28minutes"
        }
    },
    methods: {
        
        refreshCourses() {
            CourseDataService.retrieveAllCourses()
            .then((res) => {
                this.courses = res.data;
            });
        },
        addCourse() {
            this.$router.push(`/course/-1`);
        },
        updateCourse(id) {
            this.$router.push(`/course/${id}`);
        },
        deleteCourse(id) {
            CourseDataService.deleteCourse(this.INSTRUCTOR, id)
            .then(() => {
                this.refreshCourses();
            });
        },
    },
    created() {
        this.refreshCourses();
    }
}
</script>
<style scoped>
</style>

