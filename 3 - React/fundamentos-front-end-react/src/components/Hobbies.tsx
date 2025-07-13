const hobbies = [
  "Andar",
  "Comer",
  "Comer",
  "Beber"
];

export const Hobbies = () => {  
    
    const [hobbyPreferido, ...outrosHobbies] = hobbies;

    const novosHobbies = ["Dormir", "Estudar"];

    const meusHobbies = [...outrosHobbies, ...novosHobbies];


    return (
        <>
        <p>Meus hobbies são:</p>
        <ul className="list-disc pl-10">
            <li className="font-bold">{hobbyPreferido}</li>
            {meusHobbies.map((hobby, index) => (
                <li key={`hobby-${index}`}>{hobby}</li>
            ))}
        </ul>
    </>
    );
};