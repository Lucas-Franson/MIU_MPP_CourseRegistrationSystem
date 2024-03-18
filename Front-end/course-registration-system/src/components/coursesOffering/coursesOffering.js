import * as React from 'react';
import { instance } from '../../services/StudentService';
import { Alert, Button, CircularProgress, Grid, Paper, Snackbar } from '@mui/material';
import TableCourseOffering from './TableCourseOffering';

export default function CoursesOffering() {

    const [msg, setMsg] = React.useState('');
    const [alertType, setAlertType] = React.useState('warning');
    const [loadingCourses, setLoadingCourses] = React.useState(false);
    const [loadingPrioritizing, setLoadingPrioritizing] = React.useState(false);
    const [registeredCourses, setRegisteredCourses] = React.useState([]);
    const [openSnackBar, setOpenSnackBar] = React.useState(false);
    const [priority, setPriority] = React.useState([]);

    React.useEffect(() => {
        if (!loadingCourses) {
          setLoadingCourses(true);
          instance.get(`/blockCourse`).then(function ({ data }) {
              console.log(data);
              setRegisteredCourses(data);
              setLoadingCourses(false);
            })
            .catch(function (error) {
              setOpenSnackBar(true);
              setLoadingCourses(false);
              setAlertType("warning");
              setMsg(error.message);
            })
        } 
    }, []);

    const changePriority = (newPriority) => {
        let tmp = priority.filter(x => x.blockId != newPriority.blockId);
        setPriority([...tmp, newPriority]);
    }

    const handleClose = () => {
        setOpenSnackBar(false);
    }

    function studentPrioritizeCourse() {
        if (priority && priority.length > 0) {
            setLoadingPrioritizing(true);
            let email = localStorage.getItem('email');
            instance.put(`/student/${email}`, { blocks: priority })
                .then((data) => {
                    setPriority([]);
                    setLoadingPrioritizing(false);
                    setAlertType("success");
                    setMsg("Changes saved successfully!");
                    setOpenSnackBar(true);
                }).catch((err) => {
                    setAlertType("warning");
                    setMsg(err.message);
                    setOpenSnackBar(true);
                    setLoadingPrioritizing(false);
                });

        } else {
            setMsg("You do not have changes to save.");
            setAlertType("warning");
            setOpenSnackBar(true);
        }
    }

    return (
        <>
            <Snackbar
                anchorOrigin={{ vertical: "top", horizontal: "right" }}
                open={openSnackBar}
                onClose={handleClose}
                autoHideDuration={6000}
                message={msg}
                key={12}
            >
                <Alert
                    severity={alertType}
                    variant="filled"
                    sx={{ width: '100%' }}
                    >
                    {msg}
                </Alert>
            </Snackbar>

            <Grid container spacing={3}>
                <Grid item xs={12}>
                    <TableCourseOffering changePriority={changePriority} courses={registeredCourses} /> 
                </Grid>
                <Grid item xs={12}>
                    <Button variant="contained" disabled={priority.length == 0} onClick={studentPrioritizeCourse}>
                        {loadingPrioritizing ? <CircularProgress color='inherit' /> : ("Save Changes")}
                    </Button>
                </Grid>
            </Grid>


        </>
    );
}