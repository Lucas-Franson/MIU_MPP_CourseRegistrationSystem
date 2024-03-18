import * as React from 'react';
import { Box, Collapse, IconButton, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, TextField, Typography } from "@mui/material";
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import KeyboardArrowUpIcon from '@mui/icons-material/KeyboardArrowUp';
import Paper from '@mui/material/Paper';

function Row(props) {

    const { block, courses, changePriority } = props;

    const [open, setOpen] = React.useState(false);
    const [blockCourses, setBlockCourses] = React.useState(courses);

    function compareByPriority(a, b) {
        if (a.priority < b.priority) {
          return -1;
        }
        if (a.priority > b.priority) {
          return 1;
        }
        return 0;
    }

    function onChangePriority(event) {
        let id = event.currentTarget.id.split('id_')[1];
        let value = event.target.value;
        let element = blockCourses.find(x => x.blockCourseId == id);
        
        if (value <= blockCourses.length && value > 0) {
            if (value > element.priority) {
                // decrease -1 each element after id
                let tmp = blockCourses.filter(x => 
                    (x.priority < element.priority
                    || x.priority > value)
                    && x.blockCourseId != id);
                let elemToChange = blockCourses.filter(x => 
                    x.priority > element.priority 
                    && x.priority <= value
                    && x.blockCourseId != id);
                elemToChange.map(x => x.priority--);
                element.priority = value;
                setBlockCourses([...tmp, ...elemToChange, element]);
    
            } else {
                // increase +1 each element before id
                let tmp = blockCourses.filter(x => 
                    (x.priority > element.priority
                    || x.priority < value)
                    && x.blockCourseId != id);
                let elemToChange = blockCourses.filter(x => 
                    x.priority < element.priority 
                    && x.priority >= value
                    && x.blockCourseId != id);
                elemToChange.map(x => x.priority++);
                element.priority = value;
                setBlockCourses([...tmp, ...elemToChange, element]);
            }

            let priority = {};
            blockCourses.forEach(element => {
                priority[element.priority] = element.blockCourseId;
            });
            priority.blockId = block.blockId;

            changePriority(priority);
        }

    }

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
                                    <TableCell>Priority</TableCell>
                                    <TableCell>ID</TableCell>
                                    <TableCell>Title</TableCell>
                                    <TableCell>Teacher</TableCell>
                                    <TableCell>Format</TableCell>
                                    <TableCell>Capacity</TableCell>
                                    <TableCell>Enrolled</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {blockCourses && blockCourses.length > 0 ? 
                                    blockCourses
                                        .filter(x => x.block.blockId === block.blockId)
                                        .sort(compareByPriority)
                                        .map((course) => (
                                    <TableRow key={course.blockCourseId}>
                                        <TableCell component="th" scope="row">
                                        <TextField
                                            id={`id_${course.blockCourseId}`}
                                            label="Priority"
                                            type="number"
                                            style={{ width: '5ch' }}
                                            value={course.priority}
                                            onChange={(event) => onChangePriority(event)}
                                            InputLabelProps={{
                                                shrink: true,
                                            }}
                                            variant="standard"
                                            />
                                        </TableCell>
                                        <TableCell>{course.course.id}</TableCell>
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

export default function TableCourseOffering(props) {

    const [blocks, setBlocks] = React.useState([]);

    const { courses, changePriority } = props;

    React.useEffect(() => {

        if (courses) {
            let block = [];
            let priority = [];
            courses.map((course) => {
                let id = priority.find(x => x.id === course.block.blockId);
                if (id) {
                    course.priority = id.value;
                    id.value++;
                } else {
                    course.priority = 1;
                    priority.push({ id: course.block.blockId, value: 2 });
                }
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
                    <TableCell style={{ fontWeight: 'bold' }}>Block</TableCell>
                    <TableCell style={{ fontWeight: 'bold' }}>Start Date</TableCell>
                    <TableCell style={{ fontWeight: 'bold' }}>End Date</TableCell>
                </TableRow>
                </TableHead>
                <TableBody>
                {blocks.map((block) => (
                    <Row key={block.blockId} block={block} changePriority={changePriority} courses={courses.filter(x => x.block.blockId === block.blockId)} />
                ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}