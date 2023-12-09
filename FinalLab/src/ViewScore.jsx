import React from "react";
import "./ViewScore.css";

const ViewScore = ({ handleResetClick, score }) => {
  return (
    <div>
      <p>You scored {score} out of 10</p>
      <button onClick={handleResetClick}>Reset</button>
    </div>
  );
};

export default ViewScore;