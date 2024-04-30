import React from "react";
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

export default function Details() {
  const classes = useStyles();
  const bull = <span className={classes.bullet}>•</span>;

  return (
    <Card className={classes.root}>
      <CardContent>
        <Typography
          className={classes.title}
          color="textSecondary"
          variant="h5"
          gutterBottom
        >
          배송지 정보를 입력하세요.
        </Typography>
        <TextField
          id="filled-basic"
          label="수령인"
          variant="filled"
          className={classes.text}
        />
        <br />
        <TextField
          id="filled-basic"
          label="연락처"
          variant="filled"
          className={classes.text}
        />
        <br />
        <TextField
          id="filled-basic"
          label="우편번호"
          variant="filled"
          className={classes.text}
        />
        <br />
        <TextField
          id="filled-basic"
          label="주소"
          variant="filled"
          multiline
          rows={2}
          className={classes.text}
        />
      </CardContent>
    </Card>
  );
}
