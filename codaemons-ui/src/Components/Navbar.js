import React from "react";
import AccountButton from "./AccountButton";
import { fade, makeStyles } from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import InputBase from "@material-ui/core/InputBase";
import SearchIcon from "@material-ui/icons/Search";
import HomeIcon from "@material-ui/icons/Home";
import PeopleIcon from "@material-ui/icons/People";

const useStyles = makeStyles((theme) => ({
  grow: {
    flexGrow: 1,
  },
  appBar: {
    backgroundColor: "#24292E",
  },
  buttonsContainer: {
    marginLeft: theme.spacing(5),
  },
  menuText: {
    fontSize: 13,
    marginLeft: theme.spacing(0.5),
  },
  title: {
    color: "inherit",
    noWrap: true,
    marginLeft: theme.spacing(20),
  },
  search: {
    position: "relative",
    borderRadius: theme.shape.borderRadius,
    backgroundColor: fade(theme.palette.common.white, 0.15),
    "&:hover": {
      backgroundColor: fade(theme.palette.common.white, 0.25),
    },
    marginRight: theme.spacing(2),
    marginLeft: 0,
    width: "100%",
    [theme.breakpoints.up("sm")]: {
      marginLeft: theme.spacing(3),
      width: "auto",
    },
  },
  searchIcon: {
    width: theme.spacing(7),
    height: "100%",
    position: "absolute",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
  },
  inputRoot: {
    color: "inherit",
  },
  inputInput: {
    padding: theme.spacing(1, 1, 1, 7),
    transition: theme.transitions.create("width"),
    width: "100%",
    [theme.breakpoints.up("sm")]: {
      width: 120,
      "&:focus": {
        width: 200,
      },
    },
  },
  button: {
    marginRight: theme.spacing(3),
    height: 33,
  },
}));

export default function NavBar() {
  const classes = useStyles();

  return (
    <div className={classes.grow}>
      <AppBar position="static" className={classes.appBar}>
        <Toolbar>
          <Typography className={classes.title} variant="h5">
            Codaemons
          </Typography>

          <div className={classes.buttonsContainer}>
            <IconButton color="inherit">
              {" "}
              <HomeIcon />
              <Typography className={classes.menuText}>Home</Typography>
            </IconButton>
            &nbsp;&nbsp;
            <IconButton color="inherit">
              {" "}
              <PeopleIcon />
              <Typography className={classes.menuText}>Spaces</Typography>
            </IconButton>
          </div>

          <div className={classes.search}>
            <div className={classes.searchIcon}>
              <SearchIcon />
            </div>
            <InputBase
              placeholder="Search…"
              type="search"
              classes={{
                root: classes.inputRoot,
                input: classes.inputInput,
              }}
              inputProps={{ "aria-label": "search" }}
            />
          </div>
          <div className={classes.grow} />
          <div className={classes.sectionDesktop}>
            <AccountButton />
          </div>
        </Toolbar>
      </AppBar>
    </div>
  );
}
