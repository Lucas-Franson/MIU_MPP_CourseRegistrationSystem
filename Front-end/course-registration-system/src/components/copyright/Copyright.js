import { Link, Typography } from '@mui/material';
import * as React from 'react';


export default function Copyright(props) {
    return (
      <Typography variant="body2" color="text.secondary" align="center" {...props}>
        {'Copyright © '}
        <Link color="inherit" href="https://compro.miu.edu/">
          MIU Students
        </Link>{' '}
        {new Date().getFullYear()}
        {'.'}
      </Typography>
    );
}