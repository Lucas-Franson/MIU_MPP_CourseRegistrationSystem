import * as React from 'react';
import { Box, Collapse, IconButton, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Typography } from "@mui/material";
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import KeyboardArrowUpIcon from '@mui/icons-material/KeyboardArrowUp';
import Paper from '@mui/material/Paper';


function Row(props) {

    const { block, courses } = props;

    const [open, setOpen] = React.useState(false);

    return (
        <>
            <TableRow>
                <TableCell>
                    <IconButton
                        aria-label="expand row"
                        size="small"
                        onClick={() => setOpen(!open)}
                    >
                        {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
                    </IconButton>
                </TableCell>
                <TableCell component="th" scope="row">
                    Block {block.blockId}
                </TableCell>
                <TableCell>{block.startDate}</TableCell>
                <TableCell>{block.endDate}</TableCell>
            </TableRow>
            <TableRow>
                <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
                <Collapse in={open} timeout="auto" unmountOnExit>
                    <Box sx={{ margin: 1 }}>
                        <Table size="small" aria-label="purchases">
                            <TableHead>
                                <TableRow>
                                    <TableCell>ID</TableCell>
                                    <TableCell>Title</TableCell>
                                    <TableCell>Teacher</TableCell>
                                    <TableCell>Format</TableCell>
                                    <TableCell>Capacity</TableCell>
                                    <TableCell>Enrolled</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {courses && courses.length > 0 ? 
                                    courses.filter(x => x.block.blockId === block.blockId).map((course) => (
                                    <TableRow key={course.blockCourseId}>
                                        <TableCell component="th" scope="row">
                                            {course.course.id}
                                        </TableCell>
                                        <TableCell>{course.course.title}</TableCell>
                                        <TableCell>{course.teacher?.name}</TableCell>
                                        <TableCell>{course.campusOrDE}</TableCell>
                                        <TableCell>{course.capacity}</TableCell>
                                        <TableCell>{course.enrolled}</TableCell>
                                    </TableRow>
                                )) : (
                                    <TableRow key={123}>
                                        <TableCell colSpan={3} align='center'>No record available</TableCell>
                                    </TableRow>
                                )}
                            </TableBody>
                        </Table>
                    </Box>
                </Collapse>
                </TableCell>
            </TableRow>
        </>
    );
}

export default function TableCourseBlocks(props) {

    const [blocks, setBlocks] = React.useState([]);

    const { courses } = props;

    React.useEffect(() => {

        if (courses) {
            let block = [];
            courses.forEach((course) => {
                if (course.block) {
                    let exist = block.find(x => x.blockId === course.block.blockId);
                    if (!exist) {
                        let value = {
                            blockId: course.block.blockId,
                            endDate: course.block.endDate,
                            startDate: course.block.startDate
                        };
                        block.push(value);
                    }
                }
            });
            setBlocks(block);
        }

    }, [courses]);

    return (
        <TableContainer component={Paper}>
            <Table aria-label="collapsible table">
                <TableHead>
                <TableRow>
                    <TableCell />
                    <TableCell>Block ID</TableCell>
                    <TableCell>Block Start Date</TableCell>
                    <TableCell>Block End Date</TableCell>
                </TableRow>
                </TableHead>
                <TableBody>
                {blocks.map((block) => (
                    <Row key={block.blockId} block={block} courses={courses} />
                ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}