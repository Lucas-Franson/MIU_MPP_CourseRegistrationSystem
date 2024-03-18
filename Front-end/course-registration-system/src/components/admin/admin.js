import { Alert, Button, CircularProgress, Container, Snackbar, Typography } from '@mui/material';
import * as React from 'react';
import { instance } from '../../services/StudentService';

export default function Admin () {

    const [openSnackBar, setOpenSnackBar] = React.useState(false);
    const [msg, setMsg] = React.useState("");
    const [alertType, setAlertType] = React.useState('warning');
    const [loadingPrioritizing, setLoadingPrioritizing] = React.useState(false);

    const handleClose = () => {
        setOpenSnackBar(false);
    }

    function processRegistration() {
        setLoadingPrioritizing(true);
        instance.post('/admin/process-registrations')
            .then((data) => {
                if (data) {
                    setAlertType("success");
                    setMsg("Successfully registered the students!");
                } else {
                    setAlertType("warning");
                    setMsg("Something got wrong!");
                }
                setOpenSnackBar(true);
                setLoadingPrioritizing(false);
            }).catch((error) => {
                setAlertType("warning");
                setMsg(error.message);
                setOpenSnackBar(true);
                setLoadingPrioritizing(false)
            });
    }

    return (
        <>
            <Snackbar
                anchorOrigin={{ vertical: "top", horizontal: "right" }}
                open={openSnackBar}
                onClose={handleClose}
                autoHideDuration={6000}
                message={msg}
                key={1}
            >
                <Alert
                    severity={alertType}
                    variant="filled"
                    sx={{ width: '100%' }}
                    >
                    {msg}
                </Alert>
            </Snackbar>
            <Typography variant='h3' component="h2">
                Process all courses blocks
            </Typography>
            <Container maxWidth="lg" sx={{ mt: 4, mb: 4 }}>
                <Button variant="contained" disabled={loadingPrioritizing} onClick={processRegistration}>
                    {loadingPrioritizing ? <CircularProgress color='inherit' /> : ("Process Registration")}
                </Button>
            </Container>
        </>
    );
}