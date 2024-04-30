import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import FormLabel from "@material-ui/core/FormLabel";
import FormControl from "@material-ui/core/FormControl";
import FormGroup from "@material-ui/core/FormGroup";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import FormHelperText from "@material-ui/core/FormHelperText";
import Checkbox from "@material-ui/core/Checkbox";
import CardContent from "@material-ui/core/CardContent";

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

export default function PaymentMode() {
  const classes = useStyles();
  const [state, setState] = React.useState({
    card: true,
    cod: false,
  });

  const handleChange = (event) => {
    setState({ ...state, [event.target.name]: event.target.checked });
  };

  const { card, cod } = state;
  const error = [card, cod].filter((v) => v).length !== 2;
  return (
    <Card className={classes.root}>
      <CardContent>
        <FormControl component="fieldset" className={classes.formControl}>
          <FormLabel component="legend">결제 방식</FormLabel>
          <FormGroup>
            <FormControlLabel
              control={
                <Checkbox
                  checked={card}
                  onChange={handleChange}
                  name="card"
                  color="primary"
                />
              }
              label="신용/체크카드"
            />
            <FormControlLabel
              disabled
              control={
                <Checkbox checked={cod} onChange={handleChange} name="cod" />
              }
              label="무통장입금"
            />
          </FormGroup>
          <FormHelperText>* 현재 사용 불가 </FormHelperText>
        </FormControl>
      </CardContent>
    </Card>
  );
}
