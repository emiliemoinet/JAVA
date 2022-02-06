import React from 'react';
import styled from 'styled-components';
import { InputRound } from './Forms';
import { Input, Submit } from './index';

export class Settings extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      newMinutesT: props.minutesT,
      newSecondesT: props.secondesT,
      newMinutesP: props.minutesP,
      newSecondesP: props.secondesP,
      round: props.round,
    };
  }

  handleMinTChange = (value) => {
    this.setState({ newMinutesT: value.target.value });
  };

  handleSecTChange = (value) => {
    this.setState({ newSecondesT: value.target.value });
  };

  handleMinPChange = (value) => {
    this.setState({ newMinutesP: value.target.value });
  };

  handleSecPChange = (value) => {
    this.setState({ newSecondesP: value.target.value });
  };

  handleRoundChange = (value) => {
    this.setState({ round: value.target.value });
  };

  onSubmit = () => {
    this.props.setTime(
      this.state.newMinutesT,
      this.state.newSecondesT,
      this.state.newMinutesP,
      this.state.newSecondesP,
      this.state.round
    );
  };

  render() {
    return (
      <Styled>
        <form>
          <Input
            title={'Temps travail'}
            minutes={this.props.minutesT}
            secondes={this.props.secondesT}
            onMinChange={this.handleMinTChange}
            onSecChange={this.handleSecTChange}
          />
          <Input
            title={'Temps pause'}
            minutes={this.props.minutesP}
            secondes={this.props.secondesP}
            onMinChange={this.handleMinPChange}
            onSecChange={this.handleSecPChange}
          />
          <InputRound
            title={'Nombre de tours'}
            round={this.props.round}
            onRoundChange={this.handleRoundChange}
          />
        </form>
        <Submit onClick={this.onSubmit}>Valider</Submit>
      </Styled>
    );
  }
}

const Styled = styled.div`
  font-family: 'Montserrat', sans-serif;
  font-weight: bold;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  color: black;
  background-color: white;
  width: 30%;
  padding: 50px;
  border-radius: 10px;
  position: relative;
  border: solid 1px black;
  left: 50%;
  transform: translate(-50%, 25%);

  h1 {
    margin-top: 0;
  }

  form {
    display: flex;
    flex-direction: column;

    input {
      margin-top: 5px;
      margin-bottom: 10px;
    }
  }
`;
