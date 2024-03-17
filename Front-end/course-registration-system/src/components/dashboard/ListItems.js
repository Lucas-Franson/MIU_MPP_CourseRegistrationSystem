import * as React from 'react';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import PeopleIcon from '@mui/icons-material/People';
import AppRegistrationIcon from '@mui/icons-material/AppRegistration';
import SchoolIcon from '@mui/icons-material/School';
import AdminPanelSettingsIcon from '@mui/icons-material/AdminPanelSettings';

export default function MainListItems({redirect}) {
  return (
    <React.Fragment>
      <ListItemButton onClick={() => redirect("RegisteredCourses")}>
        <ListItemIcon>
          <SchoolIcon />
        </ListItemIcon>
        <ListItemText primary="Registered Courses" />
      </ListItemButton>
      <ListItemButton onClick={() => redirect("CoursesOfferings")}>
        <ListItemIcon>
          <AppRegistrationIcon />
        </ListItemIcon>
        <ListItemText primary="Courses Offerings" />
      </ListItemButton>
      <ListItemButton onClick={() => redirect("Teacher")}>
        <ListItemIcon>
          <PeopleIcon />
        </ListItemIcon>
        <ListItemText primary="Teacher" />
      </ListItemButton>
      <ListItemButton onClick={() => redirect("Admin")}>
        <ListItemIcon>
          <AdminPanelSettingsIcon />
        </ListItemIcon>
        <ListItemText primary="Admin" />
      </ListItemButton>
    </React.Fragment>
  );
}