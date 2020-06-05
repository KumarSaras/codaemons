import React, { useState } from 'react'
import { IconButton, Menu, MenuItem } from '@material-ui/core'
import AccountCircle from '@material-ui/icons/AccountCircle'
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import { useHistory } from "react-router-dom";
import AppPaths from "../AppPaths";

const useStyles = makeStyles(theme => ({
    menuText: {
      fontSize: 13,
    },  
  }));

export default function AccountButton() {
    const classes = useStyles()
    const [anchorEl, setAnchorE1] = useState(null)
    const history = useHistory();

    const handleMenu = event => {
        setAnchorE1(event.currentTarget)
    };

    const handleClose = () => {
        setAnchorE1(null)
    };

    const handleSignOutMenuItem = () => {
        history.push(AppPaths.LOGIN);
    }

    const handleSignInMenuItem = () => {
        history.push(AppPaths.LOGIN);
    }

    const isLoggedIn = () => {
        //TODO: implement it
        return true;
    }

    return (
        <div>
            <IconButton
                aria-owns={anchorEl ? 'menu-account' : undefined}
                aria-haspopup='false'
                onClick={handleMenu}
                color='inherit'>
                <AccountCircle />
            </IconButton>

            <Menu
                id='menu-account'
                anchorEl={anchorEl}
                anchorOrigin={{
                    vertical: 'top',
                    horizontal: 'right',
                }}
                transformOrigin={{
                    vertical: 'top',
                    horizontal: 'right',
                }}
                open={anchorEl}
                onClose={handleClose}>

                <MenuItem onClick={handleClose}>
                    <Typography className={classes.menuText}>Profile</Typography>
                </MenuItem>
                <MenuItem onClick={handleClose}>{
                    isLoggedIn() ? <Typography className={classes.menuText} onClick={handleSignOutMenuItem}>Sign Out</Typography> :
                                   <Typography className={classes.menuText} onClick={handleSignInMenuItem}>Sign In</Typography>
                }
                    
                </MenuItem>
            </Menu>
        </div>
    )
}