import React from "react";
import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import { useContext, useState } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";
import './Payment.css';

import { makeStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";
import TextField from "@material-ui/core/TextField";
const useStyles = makeStyles({
	root: {
	  minWidth: 400,
	  margin: "20px",
	},
	bullet: {
	  display: "inline-block",
	  margin: "0 2px",
	  transform: "scale(0.8)",
	},
	title: {
	  fontSize: 14,
	},
	pos: {
	  marginBottom: 12,
	},
	text: {
	  width: 350,
	  margin: "10px",
	},
  });

function Payment_form1() {

	const classes = useStyles();
  	const bull = <span className={classes.bullet}>•</span>;

    return (
		<div>
			<Card className={classes.root}>
				<CardContent>
					<Typography
					className={classes.title}
					color="textSecondary"
					variant="h5"
					gutterBottom
					>
					Enter Your Details
					</Typography>
					<TextField
					id="filled-basic"
					label="Username"
					variant="filled"
					className={classes.text}
					/>
					<br />
					<TextField
					id="filled-basic"
					label="Address"
					variant="filled"
					multiline
					rows={4}
					className={classes.text}
					/>
				</CardContent>
				</Card>
		</div>
	);
    
    }
    
    export default Payment_form1;