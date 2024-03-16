import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://127.0.0.1:8080'
});

export async function registerStudentIntoCourseBlock(studentId, blockCourseId) {
    return await instance.post(`/student/${studentId}/${blockCourseId}`);
}
export async function getRegisteredCourses(studentId) {
    return await instance.get(`/student/${studentId}`);
}