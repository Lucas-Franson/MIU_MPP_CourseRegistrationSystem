import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import Copyright from '../copyright/Copyright';
import { Alert, Snackbar } from '@mui/material';

// TODO remove, this demo shouldn't need to reset the theme.

const defaultTheme = createTheme();

export default function SignIn({ redirect }) {

    const [openSnackBar, setOpenSnackBar] = React.useState(false);
    const [msg, setMsg] = React.useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    if (data && data.get('email') !== "") {
        localStorage.setItem("email", data.get('email'));
        redirect(true);
    } else {
        setMsg("Email field is required!");
        setOpenSnackBar(true);
    }
  };

  const handleClose = () => {
    setOpenSnackBar(false);
  }

  return (
    <ThemeProvider theme={defaultTheme}>
        <Snackbar
            anchorOrigin={{ vertical: "top", horizontal: "right" }}
            open={openSnackBar}
            onClose={handleClose}
            autoHideDuration={6000}
            message={msg}
            key={1}
        >
            <Alert
                severity="warning"
                variant="filled"
                sx={{ width: '100%' }}
                >
                {msg}
            </Alert>
        </Snackbar>
        <Container component="main" maxWidth="xs">
            <CssBaseline />
            <Box
            sx={{
                marginTop: 8,
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
            }}
            >
            <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
                <LockOutlinedIcon />
            </Avatar>
            <Typography component="h1" variant="h5">
                Sign in
            </Typography>
            <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
                <TextField
                margin="normal"
                required
                fullWidth
                id="email"
                label="Email Address"
                name="email"
                autoComplete="email"
                autoFocus
                />
                <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
                >
                Sign In
                </Button>
            </Box>
            </Box>
            <Copyright sx={{ mt: 8, mb: 4 }} />
        </Container>
    </ThemeProvider>
  );
}