import React from 'react';
import styled from 'styled-components';

export class InputRound extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    return (
      <Styled>
        <label>{this.props.title} :</label>
        <div>
          <InputNumber
            type='number'
            defaultValue={this.props.round}
            min='1'
            onChange={this.props.onRoundChange}
          />
        </div>
      </Styled>
    );
  }
}

const Styled = styled.div`
  display: flex;
  flex-direction: column;
  text-align: center;
`;

const InputNumber = styled.input`
  width: 70px;
  height: 80px;
  font-size: 30px;
  text-align: center;
  border-radius: 10px;
`;
