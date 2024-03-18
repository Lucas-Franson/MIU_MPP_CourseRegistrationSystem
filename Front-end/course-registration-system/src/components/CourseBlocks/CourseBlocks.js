import * as React from 'react';
import { instance } from '../../services/StudentService';
import Snackbar from '@mui/material/Snackbar';
import Alert from "@mui/material/Alert";
import TableCourseBlocks from './TableCourseBlocks';

export default function CourseBlocks() {

    const [snackBar, setSnackBar] = React.useState({
        openSnackBar: false,
        vertical: 'top',
        horizontal: 'right',
    });
    const [msg, setMsg] = React.useState('');
    const [loadingCourses, setLoadingCourses] = React.useState(false);
    const [registeredCourses, setRegisteredCourses] = React.useState([]);
    const { openSnackBar, vertical, horizontal } = snackBar;
    
    React.useEffect(() => {
        if (!loadingCourses) {
          setLoadingCourses(true);
          let email = localStorage.getItem('email');
          instance.get(`/student/${email}`).then(function ({ data }) {
              console.log(data);
              setRegisteredCourses(data);
              setLoadingCourses(false);
            })
            .catch(function (error) {
              setSnackBar({...snackBar, openSnackBar: true});
              setLoadingCourses(false);
              setMsg(error.message);
            })
        } 
      }, []);

    const handleClose = () => {
        setSnackBar({ ...snackBar, openSnackBar: false });
    }

    return (
        <>
            <Snackbar
                anchorOrigin={{ vertical, horizontal }}
                open={openSnackBar}
                onClose={handleClose}
                autoHideDuration={6000}
                message={msg}
                key={vertical + horizontal}
            >
                <Alert
                    severity="warning"
                    variant="filled"
                    sx={{ width: '100%' }}
                    >
                    {msg}
                </Alert>
            </Snackbar>
            <TableCourseBlocks courses={registeredCourses} />
        </>
    );
}