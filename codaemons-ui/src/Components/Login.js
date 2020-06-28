import React, { useState } from "react";
import Avatar from "@material-ui/core/Avatar";
import Button from "@material-ui/core/Button";
import CssBaseline from "@material-ui/core/CssBaseline";
import TextField from "@material-ui/core/TextField";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import Link from "@material-ui/core/Link";
import Grid from "@material-ui/core/Grid";
import Box from "@material-ui/core/Box";
import LockOutlinedIcon from "@material-ui/icons/LockOutlined";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import Container from "@material-ui/core/Container";
import { NavLink, Redirect } from "react-router-dom";
import AppPaths from "../AppPaths";

function Copyright() {
  return (
    <Typography variant="body2" color="textSecondary" align="center">
      {"Copyright © "}
      <Link color="inherit" href="https://material-ui.com/">
        Codaemons
      </Link>{" "}
      {new Date().getFullYear()}
      {"."}
    </Typography>
  );
}

const useStyles = makeStyles(theme => ({
  paper: {
    marginTop: theme.spacing(8),
    display: "flex",
    flexDirection: "column",
    alignItems: "center"
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main
  },
  form: {
    width: "100%", // Fix IE 11 issue.
    marginTop: theme.spacing(1)
  },
  submit: {
    margin: theme.spacing(3, 0, 2)
  }
}));

function processResponse(response) {
  const statusCode = response.status;
  const data = response.json();
  return Promise.all([statusCode, data]).then(res => ({
    statusCode: res[0],
    data: res[1]
  }));
}

export default function Login() {
  
  const classes = useStyles();

  const [userDetails, setUserDetails] = useState({
    userame: "",
    password: ""
  });

  const [redirect, setRedirect] = useState(false);

  const handleUserDetailsChange = (event, propertyName) => {
    const newUserDetails = Object.assign(userDetails);
    newUserDetails[propertyName] = event.target.value;
    setUserDetails(newUserDetails);
  };

  const handleSubmit = () => {
    // TODO: call backend API to register the user
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(userDetails)
    };
    fetch('https://localhost:443/api/v1/authenticate', requestOptions)
      .then(processResponse)
      .then(res => {
        console.log(res);
        const { statusCode, data } = res;
        console.log(data)
        if(statusCode === 200){
            localStorage.setItem("token", data.token);
            setRedirect(true);
          //window.alert("Login successful");
        } else {
          window.alert("Login failed");
        }
      }).catch(error => {
        console.log(error);
      });
  };
  if (redirect) {
    return <Redirect to='/contest'/>;
  }
  return (
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <div className={classes.paper}>
        <Avatar className={classes.avatar}>
          <LockOutlinedIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Login
        </Typography>
        <form className={classes.form} noValidate>
        <TextField
            autoComplete="username"
            name="username"
            variant="outlined"
            required
            fullWidth
            id="username"
            label="Username"
            autoFocus
            onChange={e => handleUserDetailsChange(e, "username")}
              />
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            name="password"
            label="Password"
            type="password"
            id="password"
            autoComplete="current-password"
            onChange={e => handleUserDetailsChange(e, "password")}
          />
          <FormControlLabel
            control={<Checkbox value="remember" color="primary" />}
            label="Remember me"
          />
          <Button
            fullWidth
            variant="contained"
            color="primary"
            className={classes.submit}
            onClick={handleSubmit}
          >
            Login
          </Button>
          <Grid container justify="center">
            <NavLink to={AppPaths.SIGN_UP} variant="body2">
              {"Don't have an account? Sign Up"}
            </NavLink>
          </Grid>
        </form>
      </div>
      <Box mt={8}>
        <Copyright />
      </Box>
    </Container>
  );
}